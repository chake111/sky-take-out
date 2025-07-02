package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersConfirmDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import com.sky.mapper.OrderDetailMapper;
import com.sky.mapper.OrdersMapper;
import com.sky.result.PageResult;
import com.sky.service.OrdersService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: OrdersServiceImpl
 * Package: com.sky.service.impl
 * Description:
 * @Author: chake
 * @Create 2025/7/1 16:55
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 分页查询订单
     *
     * @param ordersPageQueryDTO
     * @return
     */
    @Override
    public PageResult<Orders> page(OrdersPageQueryDTO ordersPageQueryDTO) {
        PageHelper.startPage(ordersPageQueryDTO.getPage(), ordersPageQueryDTO.getPageSize());
        List<Orders> orderVOList = ordersMapper.list(ordersPageQueryDTO);
        Page<Orders> page = (Page<Orders>) orderVOList;
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据订单id查询订单详情
     *
     * @param id
     * @return
     */
    @Override
    public OrderVO getById(Long id) {
        OrderVO orderVO = ordersMapper.getById(id);
        List<OrderDetail> orderDetailList = orderDetailMapper.listByOrderId(id);
        orderVO.setOrderDetailList(orderDetailList);
        return orderVO;
    }

    /**
     * 取消订单
     *
     * @param ordersCancelDTO
     */
    @Override
    public void cancel(OrdersCancelDTO ordersCancelDTO) {
        Orders orders = Orders.builder()
                .id(ordersCancelDTO.getId())
                .cancelReason(ordersCancelDTO.getCancelReason())
                .cancelTime(LocalDateTime.now())
                .status(Orders.CANCELLED)
                .build();
        ordersMapper.update(orders);
    }

    /**
     * 统计订单数量
     * 待接订单数量、带派送订单数量、派送中订单数量
     *
     * @return
     */
    @Override
    public OrderStatisticsVO statistics() {
        OrderStatisticsVO orderStatisticsVO = OrderStatisticsVO
                .builder()
                .toBeConfirmed(ordersMapper.statistics(Orders.TO_BE_CONFIRMED))
                .confirmed(ordersMapper.statistics(Orders.CONFIRMED))
                .deliveryInProgress(ordersMapper.statistics(Orders.DELIVERY_IN_PROGRESS))
                .build();
        return orderStatisticsVO;
    }

    /**
     * 确认订单
     *
     * @param ordersConfirmDTO
     * @return void
     */
    @Override
    public void confirm(OrdersConfirmDTO ordersConfirmDTO) {
        Orders orders = Orders.builder()
                .id(ordersConfirmDTO.getId())
                .status(Orders.CONFIRMED)
                .build();
        ordersMapper.update(orders);
    }

    /**
     * 拒绝订单
     *
     * @param ordersRejectionDTO
     */
    @Override
    public void rejection(OrdersRejectionDTO ordersRejectionDTO) {
        Orders orders = Orders
                .builder()
                .id(ordersRejectionDTO.getId())
                .rejectionReason(ordersRejectionDTO.getRejectionReason())
                .status(Orders.CANCELLED)
                .build();
        ordersMapper.update(orders);
    }

    /**
     * 订单配送
     *
     * @param id
     * @return void
     */
    @Override
    public void delivery(Long id) {
        Orders orders = Orders
                .builder()
                .id(id)
                .status(Orders.DELIVERY_IN_PROGRESS)
                .build();
        ordersMapper.update(orders);
    }

    /**
     * 订单完成
     *
     * @param id
     */
    @Override
    public void complete(Long id) {
        Orders orders = Orders
                .builder()
                .id(id)
                .status(Orders.COMPLETED)
                .build();
        ordersMapper.update(orders);
    }


}

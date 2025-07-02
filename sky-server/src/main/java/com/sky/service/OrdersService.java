package com.sky.service;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersConfirmDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;

import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: OrdersService
 * Package: com.sky.service
 * Description:
 * @Author: chake
 * @Create 2025/7/1 16:55
 * @Version 1.0
 */
public interface OrdersService {
    /**
     * 分页查询订单
     *
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult<Orders> page(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据订单ID查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderVO getById(Long orderId);

    /**
     * 取消订单
     *
     * @param ordersCancelDTO
     * @return
     */
    void cancel(OrdersCancelDTO ordersCancelDTO);

    /**
     * 统计订单数据
     *
     * @return
     */
    OrderStatisticsVO statistics();

    /**
     * 接单
     *
     * @param ordersConfirmDTO
     * @return
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /**
     * 拒单
     *
     * @param ordersRejectionDTO
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    /**
     * 订单配送
     *
     * @param id
     */
    void delivery(Long id);

    /**
     * 订单完成
     *
     * @param id
     */
    void complete(Long id);
}

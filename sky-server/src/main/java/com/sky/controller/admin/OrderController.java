package com.sky.controller.admin;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrdersService;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * ClassName: OrderController
 * Package: com.sky.controller.admin
 * Description:
 * @Author: chake
 * @Create 2025/7/1 16:48
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 分页查询订单
     *
     * @param ordersPageQueryDTO
     * @return
     */
    @GetMapping("/conditionSearch")
    public Result<PageResult> page(OrdersPageQueryDTO ordersPageQueryDTO) {
        log.info("分页查询订单列表: {}", ordersPageQueryDTO);
        PageResult<Orders> ordersList = ordersService.page(ordersPageQueryDTO);
        return Result.success(ordersList);
    }

    /**
     * 获取订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/details/{id}")
    public Result<OrderVO> getOrderDetail(@PathVariable Long id) {
        log.info("根据ID获取订单详情: {}", id);
        OrderVO OrderVO = ordersService.getById(id);
        return Result.success(OrderVO);
    }

    /**
     * 取消订单
     * @param ordersCancelDTO
     * @return
     */
    @PutMapping("/cancel")
    public Result cancel(@RequestBody OrdersCancelDTO ordersCancelDTO) {
        log.info("取消订单: {}",ordersCancelDTO);
        ordersService.cancel(ordersCancelDTO);
        return Result.success();
    }

    @GetMapping("/statistics")
    public Result<OrderStatisticsVO> statistics() {
        OrderStatisticsVO orderStatisticsVO = ordersService.statistics();
        return Result.success(orderStatisticsVO);
    }
}

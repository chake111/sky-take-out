package com.sky.controller.admin;

import com.sky.dto.OrdersDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrdersService;
import com.sky.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param ordersPageQueryDTO
     * @return
     */
    @RequestMapping("/conditionSearch")
    public Result<PageResult> page(OrdersPageQueryDTO ordersPageQueryDTO) {
        log.info("分页查询订单列表: {}", ordersPageQueryDTO);
        PageResult<Orders> ordersList = ordersService.page(ordersPageQueryDTO);
        return Result.success(ordersList);
    }
}

package com.sky.service;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
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
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult<Orders> page(OrdersPageQueryDTO ordersPageQueryDTO);
}

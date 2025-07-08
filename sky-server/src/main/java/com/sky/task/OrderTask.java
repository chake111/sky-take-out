package com.sky.task;

import com.sky.constant.MessageConstant;
import com.sky.entity.Orders;
import com.sky.mapper.OrdersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: OrderTask
 * Package: com.sky.task
 * Description: 定时任务
 * @Author: chake
 * @Create 2025/7/8 15:13
 * @Version 1.0
 */
@Slf4j
@Component
public class OrderTask {

    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 定时处理超时订单
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 * * * * ? ")
    public void processTimeoutOrder() {
        log.info("定时处理超时订单：{}", LocalDateTime.now());
        List<Orders> ordersList = ordersMapper.getByStatusAndOrderTimeLT(Orders.PENDING_PAYMENT, LocalDateTime.now().minusMinutes(15));
        if (ordersList == null && ordersList.size() < 0) {
            return;
        }
        ordersList.forEach(orders -> {
            orders.setStatus(Orders.CANCELLED);
            orders.setCancelReason(MessageConstant.ORDER_TIMEOUT);
            orders.setCancelTime(LocalDateTime.now());
            ordersMapper.update(orders);
        });
    }

    /**
     * 定时处理配送中的订单
     * 每天凌晨1点执行一次
     */
    @Scheduled(cron = "0 0 1 * * ? ")
    public void processDeliveryOrder() {
        log.info("定时处理配送中的订单：{}", LocalDateTime.now());
        List<Orders> ordersList = ordersMapper.getByStatusAndOrderTimeLT(Orders.DELIVERY_IN_PROGRESS, LocalDateTime.now().minusMinutes(60));
        if (ordersList == null && ordersList.size() < 0) {
            return;
        }
        ordersList.forEach(orders -> {
            orders.setStatus(Orders.COMPLETED);
            orders.setDeliveryTime(LocalDateTime.now());
            ordersMapper.update(orders);
        });
    }
}

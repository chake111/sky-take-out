package com.sky.mapper;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: OrdersMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/7/1 16:59
 * @Version 1.0
 */
@Mapper
public interface OrdersMapper {
    /**
     * 分页查询订单
     * @param ordersPageQueryDTO
     * @return
     */
    List<Orders> list(OrdersPageQueryDTO ordersPageQueryDTO);
}

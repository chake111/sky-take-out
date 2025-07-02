package com.sky.mapper;

import com.sky.entity.OrderDetail;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * ClassName: OrderDetailMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/7/2 09:38
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper {
    /**
     * 根据订单id查询订单详情
     * @param orderId
     * @return
     */
    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> listByOrderId(Long orderId);
}

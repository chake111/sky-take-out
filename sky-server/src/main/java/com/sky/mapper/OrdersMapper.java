package com.sky.mapper;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
     *
     * @param ordersPageQueryDTO
     * @return
     */
    List<OrderVO> list(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     *
     * @param id
     * @return
     */
    OrderVO getById(Long id);

    /**
     * 取消订单
     *
     * @param orders
     * @return
     */
    void update(Orders orders);

    /**
     * 统计订单数量
     *
     * @return
     */
    @Select("select count(*) from orders where status = #{status}")
    Integer statistics(Integer status);

    /**
     *  新增订单
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 更新订单状态
     * @param orders
     */
    @Update("update orders " +
            "set status = #{status},pay_status = #{payStatus},checkout_time = #{checkoutTime} " +
            "where number = #{number}")
    void updateStatus(Orders orders);
}

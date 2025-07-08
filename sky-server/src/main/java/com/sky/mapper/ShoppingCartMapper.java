package com.sky.mapper;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
 * ClassName: ShoppingCartMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/7/7 10:31
 * @Version 1.0
 */
@Mapper
public interface ShoppingCartMapper {

    /**
     * 购物车全查询
     *
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据ID更新购物车物品数量
     *
     * @param cart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 新增购物车
     *
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart(name, image, user_id, dish_id, setmeal_id, dish_flavor, number, amount, create_time) " +
            "values (#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 清空购物车
     *
     * @param userId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    /**
     * 批量新增购物车
     *
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);

    /**
     * 根据ID删除购物车
     *
     * @param shoppingCart
     */
    @Delete("delete from shopping_cart where id = #{id}")
    void delete(ShoppingCart shoppingCart);

    /**
     * 根据用户ID和菜品ID或套餐ID查询购物车
     * @param shoppingCartDTO
     * @return
     */
    ShoppingCart get(ShoppingCartDTO shoppingCartDTO);
}

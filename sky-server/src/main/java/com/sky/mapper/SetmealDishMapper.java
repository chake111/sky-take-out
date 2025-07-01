package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 * ClassName: SetmealDishMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/6/30 11:15
 * @Version 1.0
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     *
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐和菜品多对多关系
     *
     * @param setmealDishes
     */
    @AutoFill(value = OperationType.INSERT)
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id批量删除菜品多对多关系
     *
     * @param setmealIds
     */
    void deleteBatch(List<Long> setmealIds);
}

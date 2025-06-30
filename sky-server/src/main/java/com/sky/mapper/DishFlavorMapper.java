package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: DishFlavorMapper
 * Package: com.sky.mapper
 * Description:
 * @Author: chake
 * @Create 2025/6/29 18:10
 * @Version 1.0
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * 根据id批量删除口味
     * @param dishIds
     * @return
     */
    void deleteBatch(List<Long> dishIds);

    /**
     * 批量插入口味
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id查询口味
     * @param dishId
     * @return
     */
    List<DishFlavor> getByDishId(Long dishId);
}

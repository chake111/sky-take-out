package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: DishService
 * Package: com.sky.service
 * Description:
 * @Author: chake
 * @Create 2025/6/29 17:56
 * @Version 1.0
 */
public interface DishService {

    /**
     * 保存菜品信息及其对应的口味信息
     * @param
     * @return
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 分页查询菜品信息
     * @param dishPageQueryDTO
     * @return
     */
    PageResult page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 批量删除菜品信息及其对应的口味信息
     * @param ids
     */
    void delete(List<Long> ids);
}

package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

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
     *
     * @param dishPageQueryDTO
     * @return
     */
    PageResult<DishVO> page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 批量删除菜品信息及其对应的口味信息
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据id查询菜品信息及其对应的口味信息
     * @param id
     * @return
     */
    DishDTO get(Long id);

    /**
     * 更新菜品信息及其对应的口味信息
     * @param dishDTO
     */
    void update(DishDTO dishDTO);

    /**
     * 更新菜品状态
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);

    /**
     * 根据分类id查询菜品信息
     * @param categoryId
     * @return
     */
    List<DishVO> list(Long categoryId);
}

package com.sky.service;

import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

/**
 * @author chake
 */ /*
 * ClassName: SetmealService
 * Package: com.sky.service
 * Description:
 * @Author: chake
 * @Create 2025/6/30 17:26
 * @Version 1.0
 */
public interface SetmealService {
    /**
     * 分页查询套餐信息
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult<SetmealVO> page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 根据id获取套餐信息
     * @param id
     * @return
     */
    SetmealVO getbyId(Long id);

    /**
     * 保存套餐信息
     * @param setmealDTO
     */
    void save(SetmealDTO setmealDTO);

    /**
     * 更新套餐状态
     * @param id
     * @param status
     */
    void updateStatus(Long id, Integer status);
}

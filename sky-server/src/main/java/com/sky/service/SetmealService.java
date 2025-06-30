package com.sky.service;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
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
    PageResult<SetmealVO> page(SetmealPageQueryDTO setmealPageQueryDTO);
}

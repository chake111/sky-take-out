package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/*
 * ClassName: SetmealServiceImpl
 * Package: com.sky.service.impl
 * Description:
 * @Author: chake
 * @Create 2025/6/30 17:26
 * @Version 1.0
 */
@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    SetmealMapper setmealMapper;

    @Autowired
    SetmealDishMapper setmealDishMapper;

    /**
     * 分页查询套餐信息
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @Override
    public PageResult<SetmealVO> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        Page<SetmealVO> page = setmealMapper.page(setmealPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据id查询套餐信息
     *
     * @param id
     * @return
     */
    @Override
    public SetmealVO getbyId(Long id) {
        SetmealVO setmealVO = setmealMapper.getbyId(id);
        // 套餐与菜品的多对多关系
        List<SetmealDish> setmealDishes = setmealMapper.getSetmealDishes(id);
        setmealVO.setSetmealDishes(setmealDishes);
        return setmealVO;
    }

    /**
     * 保存套餐信息
     *
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void save(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmealMapper.insert(setmeal);

        Long setmealId = setmeal.getId();

        // 保存套餐与菜品的多对多关系
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealId);
        });
        setmealDishMapper.insertBatch(setmealDishes);
    }

    /**
     * 更新套餐状态
     *
     * @param id
     * @param status
     */
    @Override
    public void updateStatus(Long id, Integer status) {
        Setmeal setmeal = Setmeal
                .builder()
                .id(id)
                .status(status)
                .build();
        setmealMapper.update(setmeal);
    }

    /**
     * 更新套餐信息
     *
     * @param setmealDTO
     */
    @Override
    @Transactional
    public void update(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmealMapper.update(setmeal);
        Long setmealId = setmeal.getId();
        // 删除原有套餐与菜品的多对多关系
        setmealDishMapper.deleteBatch(Collections.singletonList(setmealId));
        // 保存套餐与菜品的多对多关系
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(setmealId);
        });
        setmealDishMapper.insertBatch(setmealDishes);
    }

    /**
     * 批量删除套餐信息
     * @param ids
     */
    @Override
    @Transactional
    public void delete(List<Long> ids) {
        setmealDishMapper.deleteBatch(ids);
        setmealMapper.deleteBatch(ids);
    }
}

package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chake
 */ /*
 * ClassName: SetmealController
 * Package: com.sky.controller.admin
 * Description:
 * @Author: chake
 * @Create 2025/6/30 17:18
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin/setmeal")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    /**
     * 分页查询套餐
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("分页查询套餐：{}", setmealPageQueryDTO);
        PageResult<SetmealVO> setmeals = setmealService.page(setmealPageQueryDTO);
        return Result.success(setmeals);
    }

    /**
     * 根据id查询套餐
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @CacheEvict(cacheNames = "setmealCache", key = "#id")
    public Result<SetmealVO> getbyId(@PathVariable Long id) {
        log.info("查询套餐：{}", id);
        SetmealVO setmealVO = setmealService.getbyId(id);
        return Result.success(setmealVO);
    }

    /**
     * 新增套餐
     *
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.categoryId")
    public Result save(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐：{}", setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }

    /**
     * 更新套餐状态
     *
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result updateStatus(Long id, @PathVariable Integer status) {
        log.info("更新套餐状态：{},{}", id, status);
        setmealService.updateStatus(id, status);
        return Result.success();
    }

    /**
     * 更新套餐
     *
     * @param SetmealDTO
     * @return
     */
    @PutMapping
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result update(@RequestBody SetmealDTO SetmealDTO) {
        log.info("更新套餐：{}", SetmealDTO);
        setmealService.update(SetmealDTO);
        return Result.success();
    }

    @DeleteMapping
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)
    public Result delete(@RequestParam List<Long> ids) {
        log.info("批量删除套餐：{}", ids);
        setmealService.delete(ids);
        return Result.success();
    }
}

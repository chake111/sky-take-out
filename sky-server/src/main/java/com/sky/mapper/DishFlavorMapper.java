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

    void insertBatch(List<DishFlavor> flavors);
}

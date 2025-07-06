package com.sky.controller.user;

import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chake
 */ /*
 * ClassName: ShopController
 * Package: com.sky.controller.user
 * Description:
 * @Author: chake
 * @Create 2025/7/3 15:13
 * @Version 1.0
 */
@Slf4j
@RequestMapping("/user/shop")
@RestController("userShopController")
public class ShopController {

    private static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取营业状态
     *
     * @return
     */
    @GetMapping("/status")
    public Result<Integer> getShopStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("当前营业状态为：{}", status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}

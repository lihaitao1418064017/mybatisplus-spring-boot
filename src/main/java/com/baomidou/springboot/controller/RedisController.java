package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.redis.redisImpl.CacheImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @Description:    redis测试接口
* @Author:         LiHaitao
* @CreateDate:     2018/8/7 16:32
* @UpdateUser:
* @UpdateDate:     2018/8/7 16:32
* @UpdateRemark:
* @Version:        1.0.0
*/
@RestController
public class RedisController {

    @Resource
    private CacheImpl cache;

    @RequestMapping("/test")
    public User test(){
        User user=new User();
        user.setId(12L);
        user.setName("lihaitao");
        user.setAddress("陕西");
        cache.listLeftPushList(user.getName(),user);
        return (User)cache.listLeftPopList(user.getName());
    }
}

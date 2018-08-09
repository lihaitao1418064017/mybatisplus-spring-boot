package com.baomidou.springboot.controller;

import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.redis.ICache;
import com.baomidou.springboot.redis.redisImpl.CacheImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private ICache cache;

    @RequestMapping("/test")
    public User test(){
        User user=new User();
        user.setId(12L);
        user.setName("lihaitao");
        user.setAddress("陕西");
        User user1=new User();
        user.setId(1L);
        user.setAddress("qianxian");
        user.setName("liuhao");
        List<User> list=new ArrayList<User>(){{
            add(user);
            add(user1);
        }};
        /**
        * list无法序列化，需要将list中的每个单独序列化
        */
        cache.listLeftPushList(user.getName(), list);
        return (User)cache.listLeftPopList(user.getName());
    }
}

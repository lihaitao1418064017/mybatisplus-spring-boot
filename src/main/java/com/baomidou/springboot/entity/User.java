package com.baomidou.springboot.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.springboot.entity.enums.UserRoleEnum;
import lombok.Data;

/**
 * 用户表
 */
@SuppressWarnings("serial")
@TableName("user")
@Data
public class User extends SuperEntity<User> {



    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;


    /**
     * 生日
     */
    private Date birthday;


    /**
     * 头像
     */
    private String headshot;
    /**
     *个性签名
     */
    private String signature;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话
     */
    private String phone;



    private UserRoleEnum role;





}

package com.baomidou.springboot.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.springboot.entity.enums.AgeEnum;
import com.baomidou.springboot.entity.enums.PhoneEnum;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@SuppressWarnings("serial")
@Data
public class Student extends SuperEntity<Student> {

    private String name;

    private String number;

    private String grade;

    private AgeEnum age;

    private PhoneEnum phone;

    /**
     * 测试插入填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Date testDate;

}

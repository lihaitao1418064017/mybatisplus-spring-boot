package com.baomidou.springboot.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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



    /**
     * 测试插入填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Date testDate;

}

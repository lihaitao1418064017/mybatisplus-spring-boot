package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.springboot.SuperMapper;
import com.baomidou.springboot.entity.Student;
import com.baomidou.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface StudentMapper extends SuperMapper<Student> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    @Select("select test_id as id, name, age from student")
    List<Student> selectListBySQL();

    List<Student> selectListByWrapper(@Param("ew") Wrapper wrapper);

}
package com.baomidou.springboot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.springboot.entity.Student;
import com.baomidou.springboot.entity.User;

import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IStudentService extends IService<Student> {

	boolean deleteAll();

	public List<Student> selectListBySQL();

	public List<Student> selectListByWrapper(Wrapper wrapper);
}
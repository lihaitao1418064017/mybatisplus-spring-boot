package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.Student;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.mapper.StudentMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IStudentService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<Student> selectListBySQL() {
		return baseMapper.selectListBySQL();
	}

	@Override
	public List<Student> selectListByWrapper(Wrapper wrapper) {
		return baseMapper.selectListByWrapper(wrapper);
	}
}
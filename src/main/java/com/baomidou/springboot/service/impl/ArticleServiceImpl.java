package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.Article;
import com.baomidou.springboot.entity.User;
import com.baomidou.springboot.mapper.ArticleMapper;
import com.baomidou.springboot.mapper.UserMapper;
import com.baomidou.springboot.service.IArticleService;
import com.baomidou.springboot.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:
* @Author:         LiHaitao
* @CreateDate:     2018/8/4 15:36
* @UpdateUser:
* @UpdateDate:     2018/8/4 15:36
* @UpdateRemark:
* @Version:        1.0.0
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}


	@Override
	public List<Article> selectListByWrapper(Wrapper wrapper) {
		return baseMapper.selectListByWrapper(wrapper);
	}
}
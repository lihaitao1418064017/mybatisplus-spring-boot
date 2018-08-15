package com.share.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.admin.entity.Article;
import com.share.admin.mapper.ArticleMapper;
import com.share.admin.service.IArticleService;
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
		return false;
	}


	@Override
	public List<Article> selectListByWrapper(Wrapper wrapper) {
		return baseMapper.selectList(wrapper);
	}
}
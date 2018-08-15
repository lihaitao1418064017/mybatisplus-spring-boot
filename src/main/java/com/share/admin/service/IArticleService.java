package com.share.admin.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.share.admin.entity.Article;

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
public interface IArticleService extends IService<Article> {

	boolean deleteAll();

	List<Article> selectListByWrapper(Wrapper wrapper);
}
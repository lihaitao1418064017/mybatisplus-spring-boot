package com.baomidou.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.springboot.SuperMapper;
import com.baomidou.springboot.entity.Article;
import com.baomidou.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
* @Description:    文章的mapper
* @Author:         LiHaitao
* @CreateDate:     2018/8/4 15:32
* @UpdateUser:
* @UpdateDate:     2018/8/4 15:32
* @UpdateRemark:
* @Version:        1.0.0
*/
public interface ArticleMapper extends SuperMapper<Article> {

    /**
     * 自定义注入方法
     */
    int deleteAll();



    List<Article> selectListByWrapper(@Param("ew") Wrapper wrapper);

}
package com.share.admin.cache;

import com.share.admin.entity.Article;
import com.share.admin.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @Description:    文章的缓存
* @Author:         LiHaitao
* @CreateDate:     2018/8/10 13:30
* @UpdateUser:
* @UpdateDate:     2018/8/10 13:30
* @UpdateRemark:
* @Version:        1.0.0
*/
public class ArticleCache extends GuavaAbstractLoadingCache<String,Article> {
    @Autowired
    private IArticleService articleService;

    public ArticleCache() {
        //设置过期时间等
        this.setMaximumSize(1000);
    }

    @Override
    protected Article fetchData(String key) {
       return articleService.selectById(Long.parseLong(key));
    }
}

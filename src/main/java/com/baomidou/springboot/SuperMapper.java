package com.baomidou.springboot;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @Description:    mapper接口
* @Author:         LiHaitao
* @CreateDate:     2018/8/9 16:09
* @UpdateUser:
* @UpdateDate:     2018/8/9 16:09
* @UpdateRemark:
* @Version:        1.0.0
*/
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法
    void getAll();

}

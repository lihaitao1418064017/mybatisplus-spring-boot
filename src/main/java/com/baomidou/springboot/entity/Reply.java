package com.baomidou.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
* @Description:    评论回复
* @Author:         LiHaitao
* @CreateDate:     2018/8/4 15:13
* @UpdateUser:
* @UpdateDate:     2018/8/4 15:13
* @UpdateRemark:
* @Version:        1.0.0
*/
@Data
@TableName("reply")
public class Reply extends SuperEntity<Reply> {

    /**
     * 评论
     */
    private Comment comment;


    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复评论时间
     */
    private Date date=new Date();


}

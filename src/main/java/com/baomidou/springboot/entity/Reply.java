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
     * 父评论id
     */
    private Long parent_id;

    /**
     * 子评论id
     */
    private Long child_id;


}

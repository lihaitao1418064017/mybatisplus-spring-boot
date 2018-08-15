package com.share.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.admin.entity.Comments;
import com.share.admin.mapper.CommenstMapper;
import com.share.admin.service.ICommentsService;
import org.springframework.stereotype.Service;

/**
* @Description:    评论业务层实现
* @Author:         LiHaitao
* @CreateDate:     2018/8/5 15:16
* @UpdateUser:
* @UpdateDate:     2018/8/5 15:16
* @UpdateRemark:
* @Version:        1.0.0
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommenstMapper, Comments> implements ICommentsService {

}
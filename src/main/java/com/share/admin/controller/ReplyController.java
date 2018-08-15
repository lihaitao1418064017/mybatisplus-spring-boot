package com.share.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.share.admin.response.ResponseMessage;
import com.share.admin.entity.Comments;
import com.share.admin.entity.Reply;
import com.share.admin.service.ICommentsService;
import com.share.admin.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    回复评论接口
* @Author:         LiHaitao
* @CreateDate:     2018/8/6 19:29
* @UpdateUser:
* @UpdateDate:     2018/8/6 19:29
* @UpdateRemark:
* @Version:        1.0.0
*/
@RestController
@RequestMapping("/reply")
public class ReplyController extends ApiController {

    @Autowired
    private ICommentsService commentsService;

    @Autowired
    private IReplyService replyService;


    @RequestMapping("/add")
    public ResponseMessage addPhotoByArticle(@RequestParam("id") Long parentId, @RequestBody Comments child){
        Reply reply=new Reply();
        Comments comments=commentsService.selectById(parentId);
        reply.setChildId(child.getId());
        reply.setParentId(parentId);
        return ResponseMessage.ok(replyService.insert(reply));
    }

    @RequestMapping("/list")
    public ResponseMessage getByArticle(@RequestParam String id){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.ge("article",id);
        return ResponseMessage.ok(replyService.selectPage(new Page<Reply>(0, 20), queryWrapper));
    }
}

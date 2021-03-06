package com.share.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.share.admin.entity.Photos;
import com.share.admin.mapper.PhotosMapper;
import com.share.admin.service.IPhotosService;
import org.springframework.stereotype.Service;

/**
* @Description:    图片业务层实现
* @Author:         LiHaitao
* @CreateDate:     2018/8/4 21:54
* @UpdateUser:
* @UpdateDate:     2018/8/4 21:54
* @UpdateRemark:
* @Version:        1.0.0
*/
@Service
public class PhotosServiceImpl extends ServiceImpl<PhotosMapper, Photos> implements IPhotosService {

}
package com.baomidou.springboot.controller;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.springboot.ResponseMessage;
import com.baomidou.springboot.service.IPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
* @Description:    文件上传接口
* @Author:         LiHaitao
* @CreateDate:     2018/8/4 20:43
* @UpdateUser:
* @UpdateDate:     2018/8/4 20:43
* @UpdateRemark:
* @Version:        1.0.0
*/
@RequestMapping({"/file"})
public abstract class FileUploadController {

    //文件保存路劲
    @Value("${share.file.storage.path}")
    private String fileStoragePath;

    @Autowired
    private IPhotosService photosService;

    @Autowired
    protected MultipartProperties multipartProperties;

    public FileUploadController() {
    }


    /**
    * @Description:     上传图片，个人头像，返回图片名给前台后存储在数据库中
    * @Author:         Lihaitao
    * @Date:       2018/8/4 22:03
    * @UpdateUser:
    * @UpdateRemark:
    */
    @PostMapping({"/upload"})
    public ResponseMessage<String> upload(@RequestParam("file") MultipartFile file) {
        //文件后缀名
        return ResponseMessage.ok(fileTransferTo(file));
    }

      /**
      * @Description: 多图片上传，文章图片，返回图片的名称list
      * @Author:         Lihaitao
      * @Date:       2018/8/4 22:07
      * @UpdateUser:
      * @UpdateRemark:
      */
    @PostMapping({"/multi_upload"})
    public ResponseMessage<List<String>> multiUpload(@RequestParam("file") List<MultipartFile> files) {
       return ResponseMessage.ok( files.stream().map((file) -> {
           return fileTransferTo(file);
       }).collect(Collectors.toList()));
    }
    /**
    * @Description: 获取文件后缀名: .jpg...
    * @Author:         Lihaitao
    * @Date:       2018/8/4 21:38
    * @UpdateUser:
    * @UpdateRemark:
    */
    protected String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
    * @Description:    单个文件上传方法，将文件写入磁盘后，返回文件的新名称
    * @Author:         Lihaitao
    * @Date:       2018/8/4 22:37
    * @UpdateUser:
    * @UpdateRemark:
    */
    private String fileTransferTo(MultipartFile file){
        String fileNameExtension = this.getFileExtension(file);
        String newFileName=RandomUtil.simpleUUID()+fileNameExtension;
        try{
            file.transferTo(new File(fileStoragePath,newFileName));
        }catch (IOException e){
        }
        return newFileName;
    }
}


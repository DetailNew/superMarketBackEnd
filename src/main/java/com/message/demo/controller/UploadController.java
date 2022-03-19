package com.message.demo.controller;


import com.message.demo.utils.UploadImage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @RequestMapping("image")
    public String uploadImage(@RequestParam(value = "file") MultipartFile multipartFile){
//        调动上传工具类
        String imagePath = UploadImage.upload(multipartFile);
        if(imagePath != null){
            return "上传成功";
        }
        else {
            return "上传失败";
        }
    }

//    @RequestMapping("getImage")

}

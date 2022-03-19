package com.message.demo.controller;

import com.message.demo.bean.Image;
import com.message.demo.service.ImageService;
import com.message.demo.service.ImageServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {
    @Resource
    private ImageService imageService = new ImageServiceImpl();

    @RequestMapping(value = "/selectImage",method = RequestMethod.GET)
    public List<Image> selectImage(@RequestParam(value = "id") int id){
        return imageService.selectImage(id);
    }
}

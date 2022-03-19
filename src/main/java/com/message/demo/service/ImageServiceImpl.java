package com.message.demo.service;

import com.message.demo.bean.Image;
import com.message.demo.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl implements ImageService{
    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public List<Image> selectImage(int id) {
        return photoMapper.selectImage(id);
    }
}

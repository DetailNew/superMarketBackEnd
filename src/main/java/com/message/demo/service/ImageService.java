package com.message.demo.service;

import com.message.demo.bean.Image;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ImageService {
    public List<Image> selectImage(int id);
}

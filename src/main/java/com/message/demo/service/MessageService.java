package com.message.demo.service;

import com.message.demo.bean.Umessage;

import java.util.List;

public interface MessageService {
    public List<Umessage> selectAll();
    public List<Umessage> updateMessage(String name,String info,String times,String secret);
}

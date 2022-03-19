package com.message.demo.service;

import com.message.demo.bean.Umessage;
import com.message.demo.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Umessage> selectAll(){
        return messageMapper.selectAll();
    }

    @Override
    public List<Umessage> updateMessage(String name,String info,String times,String secret){
        messageMapper.updateMessage(name,info,times,secret);
        return null;
    }
}

package com.message.demo.controller;

import com.message.demo.bean.Umessage;
import com.message.demo.service.MessageService;
import com.message.demo.service.MessageServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {
    @Resource
    private MessageService messageService = new MessageServiceImpl();

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Umessage> selectAll() {
//        只返回100条数据
        List<Umessage> list = messageService.selectAll();
        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public List<Umessage> addMessage(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "info") String info,
                                     @RequestParam(value = "times") String times,
                                     @RequestParam(value = "secret") String secret){
        return messageService.updateMessage(name,info,times,secret);
    }
}

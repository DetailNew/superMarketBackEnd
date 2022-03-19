package com.message.demo.controller;

import com.message.demo.bean.Result;
import com.message.demo.bean.Users;
import com.message.demo.service.UserService;
import com.message.demo.service.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;
import javax.swing.*;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService = new UserServiceImpl();

    @RequestMapping(value = "selectUser", method = RequestMethod.GET)
    public List<Users> selectUser(@RequestParam(value = "account") String account,
                                  @RequestParam(value = "password") String password){
        List<Users> list = userService.selectUser(account, password);
        return list;
    }

    @RequestMapping(value = "insertUsers", method = RequestMethod.GET)
    public Result insertUsers(@RequestParam(value = "account") String account,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "time") String time,
                              @RequestParam(value = "phone") String phone){
        Result result = new Result();
        int code = 200;
        String res = "添加用户成功";
        try{
            userService.insertUsers(account, password, time, phone);
        }catch (Exception e){
            code = 500;
            res = "添加用户失败";
        }
        result.setCode(code);
        result.setResult(res);
        return result;
    }
}

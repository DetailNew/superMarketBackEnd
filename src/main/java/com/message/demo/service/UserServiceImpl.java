package com.message.demo.service;

import com.message.demo.bean.Result;
import com.message.demo.bean.Users;
import com.message.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void insertUsers(String account, String password, String time, String phone) {
        usersMapper.insertUsers(account, password, time, phone);
    }

    @Override
    public List<Users> selectUser(String account, String password) {
        return usersMapper.selectUser(account,password);
    }
}

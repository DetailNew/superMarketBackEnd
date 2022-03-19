package com.message.demo.service;


import com.message.demo.bean.Result;
import com.message.demo.bean.Users;
;

import java.util.List;



public interface UserService {
    public void insertUsers(String account, String password, String time, String phone);
    public List<Users> selectUser(String account,String password);
}

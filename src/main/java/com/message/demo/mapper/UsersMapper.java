package com.message.demo.mapper;

import com.message.demo.bean.Result;
import com.message.demo.bean.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Insert({
            "insert into users(account,password,time,phone) " +
                    "value(#{account},#{password},#{time},#{phone})"
    })
    void insertUsers(@Param("account") String account,
                       @Param("password") String password,
                       @Param("time") String time,
                       @Param("phone") String phone);

    @Select({
            "select * from users where account=#{account} and password=#{password}"
    })
    List<Users> selectUser(@Param("account") String account,
                           @Param("password") String password);
}

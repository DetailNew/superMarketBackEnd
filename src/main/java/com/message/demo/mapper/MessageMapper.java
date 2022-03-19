package com.message.demo.mapper;

import com.message.demo.bean.Result;
import com.message.demo.bean.Umessage;
import com.message.demo.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select({
            "select * from umessage where secret='公开' order by id desc limit 50;"
    })
    List<Umessage> selectAll();

    @Insert({
            "insert into umessage(name,info,times,secret) value(#{name},#{info},#{times},#{secret})"
    })
    void updateMessage(@Param("name") String name,
                         @Param("info") String info,
                         @Param("times") String times,
                         @Param("secret") String secret);
}

package com.message.demo.mapper;

import com.message.demo.bean.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhotoMapper {
    @Select({
            "select * from photos where id=#{id}"
    })
    List<Image> selectImage(@Param("id") int id);
}

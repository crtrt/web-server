package com.example.demo.dao;

import com.example.demo.domain.EventImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventImageMapper {
    @Select("SELECT * FROM event_image WHERE id=#{param0}")
    public EventImage selectByPrimaryKey(int id);
}

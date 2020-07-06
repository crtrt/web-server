package com.example.demo.dao;

import com.example.demo.domain.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventMapper {
    //事件插入
    @Insert("INSERT INTO event_info VALUES (#{id},#{event_type},#{event_date},#{event_location},#{event_desc},#{oldperson_id})")
    public int addEvent(Event event);

    //事件查询
    @Select("SELECT * FROM event_info WHERE oldperson_id=#{oldperson_id}")
    public Event selectByOldid(int id);

    @Select("SELECT * FROM event_info WHERE id=#{id}")
    public Event selectByPrimaryKey(int id);

    @Select("SELECT * FROM event_info WHERE oldperson_id=#{oldperson_id} AND event_type=#{event_type}")
    public Event select(int id, int type);

    @Select("SELECT * FROM event_info")
    public List<Event> selectAll();
}

package com.example.demo.dao;

import com.example.demo.domain.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface EventMapper {
    //事件插入
    @Insert("INSERT INTO event_info VALUES (#{id},#{event_type},#{event_date},#{event_location},#{event_desc},#{oldperson_id})")
    public int addEvent(Event event);

    //事件查询
    @Select("SELECT * FROM event_info WHERE oldperson_id=#{param0}")
    public List<Event> selectByOldid(int id);

    @Select("SELECT * FROM event_info WHERE id=#{param0}")
    public Event selectByPrimaryKey(int id);

    @Select("SELECT * FROM event_info WHERE event_type=#{param0}")
    public List<Event> selectByEventType(int type);

    @Select("SELECT * FROM event_info WHERE oldperson_id=#{param0} AND event_type=#{param1}")
    public List<Event> select(int id, int type);

    @Select("SELECT * FROM event_info")
    public List<Event> selectAll();

    @Select("SELECT COUNT(*) FROM event_info WHERE event_type=#{param0}")
    public int typenum(int event_type);

   /* @SelectKey(statement = "",keyProperty = "",before = false,resultType = int.class)
    public Event controller();*/
}

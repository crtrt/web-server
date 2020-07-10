package com.example.demo.service;

import com.example.demo.domain.Event;
import com.example.demo.domain.EventImage;

import java.util.List;

public interface EventService {
    //添加事件
    boolean addEvent(Event event);
    //通过老人id查找
    List<Event> selectByOldid(int id);
    //通过事件类型查找
    List<Event> selectByEventType(int type);
    //通过id查找
    Event selectByPrimaryKey(int id);
    //通过老人id及事件类型查找
    List<Event> select(int id, int type);
    //事件列表
    List<Event> selectAll();
    //通过事件类型统计事件数量
    int typenum(int type);
}

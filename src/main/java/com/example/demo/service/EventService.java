package com.example.demo.service;

import com.example.demo.domain.Event;
import com.example.demo.domain.EventImage;

import java.util.List;

public interface EventService {
    /*//添加事件
    boolean addEvent(Event event);*/
    //通过老人查找
    List<Event> selectByOld(String name);
    //通过事件类型查找
    List<Event> selectByEventType(int type);
    //通过id查找
    Event selectByPrimaryKey(int id);
    //通过老人及事件类型查找
    int select(String name, int type);
    //事件列表
    List<Event> selectAll();
    //通过事件类型统计事件数量
    int typenum(int type);
}

package com.example.demo.service;

import com.example.demo.domain.Event;

import java.util.List;

public interface EventService {
    boolean addEvent(Event event);

    Event selectByOldid(int id);

    Event selectByPrimaryKey(int id);

    Event select(int id, int type);

    List<Event> selectAll();
}

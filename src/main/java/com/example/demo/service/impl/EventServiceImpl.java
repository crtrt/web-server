package com.example.demo.service.impl;

import com.example.demo.dao.EventMapper;
import com.example.demo.domain.Event;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public boolean addEvent(Event event) { return eventMapper.addEvent(event)>0?true:false; }

    @Override
    public Event selectByOldid(int id) { return eventMapper.selectByOldid(id); }

    @Override
    public Event selectByEventType(int type) { return eventMapper.selectByEventType(type); }

    @Override
    public Event selectByPrimaryKey(int id) { return eventMapper.selectByPrimaryKey(id); }

    @Override
    public Event select(int id, int type) { return eventMapper.select(id, type); }

    @Override
    public List<Event> selectAll() { return eventMapper.selectAll(); }
}

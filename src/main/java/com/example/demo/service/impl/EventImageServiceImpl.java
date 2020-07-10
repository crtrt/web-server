package com.example.demo.service.impl;

import com.example.demo.dao.EventImageMapper;
import com.example.demo.domain.EventImage;
import com.example.demo.service.EventImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventImageServiceImpl implements EventImageService {
    @Autowired
    private EventImageMapper eventImageMapper;

    @Override
    public EventImage selectByPrimaryKey(int id) {
        return eventImageMapper.selectByPrimaryKey(id);
    }
}

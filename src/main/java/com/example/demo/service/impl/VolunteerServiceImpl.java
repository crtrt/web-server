package com.example.demo.service.impl;

import com.example.demo.domain.Volunteer;
import com.example.demo.service.VolunteerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Override
    public boolean updateByPrimaryKey(int id) {
        return false;
    }

    @Override
    public Volunteer selectByPrimaryKey(int id) {
        return null;
    }

    @Override
    public List<Volunteer> selectAll() {
        return null;
    }
}

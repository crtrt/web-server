package com.example.demo.service;

import com.example.demo.domain.Volunteer;

import java.util.List;

public interface VolunteerService {
    //改
    boolean updateByPrimaryKey(int id);
    //查
    Volunteer selectByPrimaryKey(int id);
    List<Volunteer> selectAll();
}

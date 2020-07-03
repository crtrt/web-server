package com.example.demo.service;

import com.example.demo.domain.Volunteer;

import java.util.List;

public interface VolunteerService {
    //增
    boolean insertVolunteer(Volunteer volunteer);
    //删
    boolean deleteVolunteer(int id);
    //改
    boolean updateByPrimaryKey(int id, Volunteer volunteer);
    //查
    Volunteer selectByPrimaryKey(int id);
    List<Volunteer> selectAll();
    int getnum();
}

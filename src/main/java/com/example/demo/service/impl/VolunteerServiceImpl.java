package com.example.demo.service.impl;

import com.example.demo.dao.VolunteerMapper;
import com.example.demo.domain.Volunteer;
import com.example.demo.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerMapper volunteerMapper ;

    @Override
    public boolean updateByPrimaryKey(int id, Volunteer volunteer) {
        return volunteerMapper.updateByPrimaryKey(id,volunteer)>0?true:false;
    }

    @Override
    public Volunteer selectByPrimaryKey(int id) {
        return volunteerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkbyPrimaryKey(int id) {
        return volunteerMapper.checkByPrimaryKey(id)>0?true:false;
    }

    @Override
    public List<Volunteer> selectAll() {
        return volunteerMapper.selectAll();
    }

    @Override
    public boolean insertVolunteer(Volunteer volunteer) { return volunteerMapper.insertVolunteer(volunteer)>0?true:false; }

    @Override
    public boolean deleteVolunteer(int id) {
        return volunteerMapper.deleteVolunteer(id)>0?true:false;
    }
    @Override
    public int getnum() { return volunteerMapper.getNum(); }
}

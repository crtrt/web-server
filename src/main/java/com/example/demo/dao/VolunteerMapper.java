package com.example.demo.dao;

import com.example.demo.domain.Volunteer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VolunteerMapper {

    @Select("SELECT * FROM volunteer_info")
    List<Volunteer> selectAll();

    @Select("Select * FROM volunteer_info WHERE id=#{0}")
    Volunteer selectByPrimaryKey(int id);


}

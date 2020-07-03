package com.example.demo.service;

import com.example.demo.domain.Oldperson;

import java.util.List;

public interface OldpersonService {
    //增
    boolean insertOldperson(Oldperson oldperson);
    //删
    boolean deleteOldperson(int id);
    //改
    boolean updateByPrimaryKey(int id, Oldperson oldperson);
    //查
    List<Oldperson> selectAll();
    Oldperson selectByPrimaryKey(int id);
    boolean checkbyPrimaryKey(int id);
    int getnum();
}

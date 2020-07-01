package com.example.demo.service;

import com.example.demo.domain.Oldperson;

import java.util.List;

public interface OldpersonService {
    //增
    void insertOldperson(Oldperson oldperson);
    //删
    void deleteOldperson(int id);
    //改
    void updataByPrimaryKey(int id, Oldperson oldperson);
    //查
    List<Oldperson> selectAllPeron();
}

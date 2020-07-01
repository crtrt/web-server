package com.example.demo.dao;

import com.example.demo.domain.Oldperson;

import java.util.List;

public interface OldpersonMapper {
    //增
    void insertOldperson(Oldperson oldperson);
    //删
    void deleteOldperson(int id);
    //改
    void updataByPrimaryKey(int id);
    //查
    List<Oldperson> selectAllPeron();
}

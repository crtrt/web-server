package com.example.demo.service.impl;

import com.example.demo.dao.OldpersonMapper;
import com.example.demo.domain.Oldperson;
import com.example.demo.service.OldpersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OldpersonServiceImpl implements OldpersonService {

    @Autowired
    private OldpersonMapper oldpersonMapper;
    @Override
    public boolean insertOldperson(Oldperson oldperson) {
        return false;
    }

    @Override
    public boolean deleteOldperson(int id) {
        return oldpersonMapper.deleteOldperson(id)>0?true:false;
    }

    @Override
    public boolean updateByPrimaryKey(int id, Oldperson oldperson) {
        return oldpersonMapper.updateByPrimaryKey(id,oldperson)>0?true:false;
    }

    @Override
    public List<Oldperson> selectAll() {
        return oldpersonMapper.selectAll();
    }

    @Override
    public Oldperson selectByPrimaryKey(int id) {
        return oldpersonMapper.selectByPrimaryKey(id);
    }
}

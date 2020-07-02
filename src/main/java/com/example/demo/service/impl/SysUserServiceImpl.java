package com.example.demo.service.impl;

import com.example.demo.dao.SysUserMapper;
import com.example.demo.domain.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sUserMapper;

    @Override
    public boolean verifypasswd(String name, String password) {

        return sUserMapper.verifyPassword(name, password)>0?true:false;
    }

    @Override
    public boolean addSysUser(SysUser sysUser) {
        return sUserMapper.addSysUser(sysUser)>0?true:false;
    }

    @Override
    public int getsUserID(String name, String password) {
        return sUserMapper.getsUserID(name, password);
    }

    @Override
    public int getUserNum() {
        return sUserMapper.getnum();
    }
}

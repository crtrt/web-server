package com.example.demo.service;

import com.example.demo.domain.SysUser;

import java.util.List;

public interface SysUserService {
    //验证登录
    boolean verifypasswd(String name, String password);
    //注册
    boolean addSysUser(SysUser sysUser);
    //ID
    int getsUserID(String name, String password);
    /*//num
    //int getUserNum();*/
    //修改信息
    boolean updateByPrimaryKey(int id, SysUser sUser);
    //查
    SysUser selectByPrimaryKey(int id);
    List<SysUser> selectAll();
    int getnum();
}

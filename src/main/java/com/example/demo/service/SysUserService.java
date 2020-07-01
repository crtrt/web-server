package com.example.demo.service;

import com.example.demo.domain.SysUser;

public interface SysUserService {
    //验证登录
    boolean verifypasswd(String name, String password);
    //注册
    void addSysUser(SysUser sysUser);
    //ID
    int getsUserID(String name, String password);
    //num
    int getUserNum();
}

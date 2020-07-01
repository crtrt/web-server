package com.example.demo.dao;

import com.example.demo.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("SELECT COUNT(*) FROM sys_user where userName=#{UserName} and password=#{Password}")
    int verifyPassword(String username, String password);

    @Insert("INSERT INTO sys_user(ID, UserName, Password, REAL_NAME, SEX, EMAIL, PHONE, MOBILE)" +
            "VALUES (#{ID},#{UserName},#{Password},#{REAL_NAME},#{SEX},#{EMAIL},#{PHONE},#{MOBILE}")
    void addSysUser(SysUser sysUser);

    @Select("SELECT COUNT(*) FROM sys_user")
    int selectall();
}

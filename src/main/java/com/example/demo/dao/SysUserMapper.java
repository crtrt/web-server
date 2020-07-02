package com.example.demo.dao;

import com.example.demo.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("SELECT COUNT(*) FROM sys_user where UserName=#{0} and Password=#{1}")
    int verifyPassword(String username, String password);

    @Insert("INSERT INTO sys_user(ID, ORG_ID, CLIENT_ID, UserName, Password, REAL_NAME, SEX, EMAIL, PHONE, MOBILE,CREATED)" +
            "VALUES (#{ID},#{ORG_ID},#{CLIENT_ID},#{UserName},#{Password},#{REAL_NAME},#{SEX},#{EMAIL},#{PHONE},#{MOBILE},#{CREATED})")
    void addSysUser(SysUser sysUser);

    @Select("SELECT COUNT(*) FROM sys_user")
    int getnum();

    @Select("SELECT ID FROM sys_user where UserName=#{0} and Password=#{1}")
    int getsUserID(String username, String password);
}

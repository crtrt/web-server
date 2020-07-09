package com.example.demo.dao;

import com.example.demo.domain.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserMapper {
    @Select("SELECT COUNT(*) FROM sys_user where UserName=#{0} and Password=#{1}")
    int verifyPassword(String username, String password);

    @Insert("INSERT INTO sys_user(ID, ORG_ID, CLIENT_ID, UserName, Password, REAL_NAME, SEX, EMAIL, PHONE, MOBILE,CREATED,ISACTIVE,logoimage)" +
            "VALUES (#{ID},#{ORG_ID},#{CLIENT_ID},#{UserName},#{Password},#{REAL_NAME},#{SEX},#{EMAIL},#{PHONE},#{MOBILE},#{CREATED},'1',#{logoimage})")
    int addSysUser(SysUser sysUser);

    @Select("SELECT COUNT(*) FROM sys_user")
    int getnum();

    @Select("SELECT ID FROM sys_user where UserName=#{0} and Password=#{1}")
    int getsUserID(String username, String password);

    @Select("SELECT * FROM sys_user")
    List<SysUser> selectAll();

    @Select("SELECT * FROM sys_user where ID=#{param1}")
    SysUser selectByPrimaryKey(int id);

    @Update("UPDATE sys_user SET UserName=#{param2.UserName},REAL_NAME=#{param2.REAL_NAME},EMAIL=#{param2.EMAIL},PHONE=#{param2.PHONE},MOBILE=#{param2.MOBILE} " +
            "WHERE ID=#{param1}")
    int updateByPrimaryKey(int id, SysUser sUser);

    @Update("UPDATE sys_user SET Password=#{1} WHERE ID=#{0}")
    int changPwd(int id, String pwd);
}

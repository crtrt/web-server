package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    int verifyPassword(String username, String password);
}

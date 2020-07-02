package com.example.demo.dao;

import com.example.demo.domain.Oldperson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OldpersonMapper {
    //增
    @Insert("")
    int insertOldperson(Oldperson oldperson);

    //删
    int deleteOldperson(int id);

    //改
    @Update("UPDATE oldperson_info SET " +
            "username=#{param2.username},gender=#{param2.gender},phone=#{param2.phone},id_card=#{param2.id_card},birthday=#{param2.birthday},room_number=#{param2.room_number}," +
            "firstguardian_name=#{param2.firstguardian_name},firstguardian_relationship=#{param2.firstguardian_relationship},firstguardian_phone=#{param2.firstguardian_phone},firstguardian_wechat=#{param2.firstguardian_wechat}," +
            "secondguardian_name=#{param2.secondguardian_name},secondguardian_relationship=#{param2.secondguardian_relationship},secondguardian_phone=#{param2.secondguardian_phone},secondguardian_wechat=#{param2.secondguardian_wechat}," +
            "UPDATED=#{param2.UPDATED},UPDATEBY=#{param2.UPDATEBY} " +
            "WHERE ID=#{param1}")
    int updateByPrimaryKey(int id, Oldperson oldperson);

    //查
    @Select("SELECT * FROM oldperson_info WHERE ID=#{0}")
    Oldperson selectByPrimaryKey(int id);

    @Select("SELECT * FROM oldperson_info")
    List<Oldperson> selectAll();
}

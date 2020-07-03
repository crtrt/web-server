package com.example.demo.dao;

import com.example.demo.domain.Volunteer;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface VolunteerMapper {

    //增
    @Insert("INSERT INTO volunteer_info(ID,ORG_ID,CLIENT_ID,name,gender,phone,id_card,birthday,ISACTIVE) VALUES " +
            "(#{ID},#{ORG_ID},#{CLIENT_ID},#{name},#{gender},#{phone},#{id_card},#{birthday},'1')")
    int insertVolunteer(Volunteer volunteer);

    //删
    @Update("UPDATE volunteer_info SET ISACTIVE='0' WHERE ID=#{param1}")
    int deleteVolunteer(int id);

    //改
    @Update("UPDATE volunteer_info SET " +
            "name=#{param2.name},gender=#{param2.gender},phone=#{param2.phone},id_card=#{param2.id_card},birthday=#{param2.birthday}," +
            "UPDATED=#{param2.UPDATED},UPDATEBY=#{param2.UPDATEBY} " +
            "WHERE ID=#{param1}")
    int updateByPrimaryKey(int id, Volunteer volunteer);


    //查
    @Select("SELECT * FROM volunteer_info  WHERE ISACTIVE='1' " )
    List<Volunteer> selectAll();

    @Select("Select * FROM volunteer_info WHERE id=#{0} AND ISACTIVE='1'")
    Volunteer selectByPrimaryKey(int id);

    @Select("SELECT COUNT(*) FROM volunteer_info")
    int getNum();
}

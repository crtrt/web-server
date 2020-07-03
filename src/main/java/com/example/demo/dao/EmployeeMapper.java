package com.example.demo.dao;

import com.example.demo.domain.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //增
    @Insert("INSERT INTO employee_info(id,ORG_ID,CLIENT_ID,username,gender,phone,id_card,birthday,hire_date,ISACTIVE,CREATED,CREATEBY) VALUES " +
            "(#{ID},#{ORG_ID},#{CLIENT_ID},#{username},#{gender},#{phone},#{id_card},#{birthday},#{hire_date},'1',#{CREATED},#{CREATEBY})")
    int insertEmployee(Employee employee);

    //删
    @Update("UPDATE employee_info SET ISACTIVE='0' WHERE ID=#{param1}")
    int deleteEmployee(int id);

    //改
    @Update("UPDATE employee_info SET " +
            "username=#{param2.username},gender=#{param2.gender},phone=#{param2.phone},id_card=#{param2.id_card},birthday=#{param2.birthday}," +
            "resign_date=#{param2.resign_date},UPDATED=#{param2.UPDATED},UPDATEBY=#{param2.UPDATEBY} " +
            "WHERE ID=#{param1}")
    int updateByPrimaryKey(int id, Employee employee);

    //查
    @Select("SELECT * FROM employee_info WHERE ID=#{0} AND ISACTIVE='1' ")
    Employee selectByPrimaryKey(int id);

    @Select("SELECT * FROM employee_info WHERE ISACTIVE='1' ")
    List<Employee> selectAll();

    @Select("SELECT COUNT(*) FROM employee_info")
    int getNum();
}

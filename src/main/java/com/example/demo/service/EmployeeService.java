package com.example.demo.service;

import com.example.demo.domain.Employee;

import java.util.List;

public interface EmployeeService {
    //改
    boolean updateByPrimaryKey(int id, Employee employee);
    //查
    Employee selectByPrimaryKey(int id);
    boolean checkbyPrimaryKey(int id);
    List<Employee> selectAll();
    int getnum();
    //增
    boolean insertEmployee(Employee employee);
    //删
    boolean deleteByPrimaryKey(int id);
}

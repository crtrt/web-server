package com.example.demo.service;

import com.example.demo.domain.Employee;

import java.util.List;

public interface EmployeeService {
    //改
    boolean updateByPrimaryKey(int id);
    //查
    Employee selectByPrimaryKey(int id);
    List<Employee> selectAll();
}

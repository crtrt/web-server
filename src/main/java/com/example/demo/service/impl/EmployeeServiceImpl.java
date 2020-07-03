package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeMapper;
import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public boolean updateByPrimaryKey(int id, Employee employee) {
        return employeeMapper.updateByPrimaryKey(id,employee)>0?true:false;
    }

    @Override
    public Employee selectByPrimaryKey(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean checkbyPrimaryKey(int id) {
        return employeeMapper.checkByPrimaryKey(id)>0?true:false;
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public int getnum() { return employeeMapper.getNum(); }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee)>0?true:false;
    }

    @Override
    public boolean deleteByPrimaryKey(int id) {
        return employeeMapper.deleteEmployee(id)>0?true:false;
    }
}

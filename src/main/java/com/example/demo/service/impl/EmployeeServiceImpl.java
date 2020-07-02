package com.example.demo.service.impl;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public boolean updateByPrimaryKey(int id) {
        return false;
    }

    @Override
    public Employee selectByPrimaryKey(int id) {
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        return null;
    }
}

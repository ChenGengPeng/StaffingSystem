package com.springboot.staffingsystem.service.impl;

import com.springboot.staffingsystem.bean.Department;
import com.springboot.staffingsystem.dao.DepartmentMapper;
import com.springboot.staffingsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}

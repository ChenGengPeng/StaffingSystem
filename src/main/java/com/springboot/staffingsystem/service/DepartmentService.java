package com.springboot.staffingsystem.service;

import com.springboot.staffingsystem.bean.Department;

import java.util.List;

public interface DepartmentService {

    //获取所有部门
  List<Department> getDepts();
}

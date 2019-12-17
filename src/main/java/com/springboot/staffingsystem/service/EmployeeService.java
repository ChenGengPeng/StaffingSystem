package com.springboot.staffingsystem.service;

import com.springboot.staffingsystem.bean.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有的员工
    List<Employee> getAll();
    //员工保存
    void saveEmp(Employee employee);
    //根据员工id查询员工
    Employee getEmp(Integer id);

    //员工更新
    void updateEmp(Employee employee);
    //员工删除
    void deleteEmp(Integer id);

    //检查用户名是否可用
    boolean checkUser(String empName);
    //批量删除
     void deleteBatch(List<Integer> ids);

}

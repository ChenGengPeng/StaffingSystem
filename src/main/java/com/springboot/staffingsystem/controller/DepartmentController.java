package com.springboot.staffingsystem.controller;

import com.springboot.staffingsystem.bean.Department;
import com.springboot.staffingsystem.bean.Msg;
import com.springboot.staffingsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     *
     * @return 返回所有部门信息
     */
    @RequestMapping("/getDepts")
    public List<Department> getDepts(){
        List<Department> list = departmentService.getDepts();
        return list;
    }
}

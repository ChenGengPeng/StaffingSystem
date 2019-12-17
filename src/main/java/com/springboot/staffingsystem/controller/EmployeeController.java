package com.springboot.staffingsystem.controller;

import com.springboot.staffingsystem.bean.Employee;
import com.springboot.staffingsystem.bean.Msg;
import com.springboot.staffingsystem.service.EmployeeService;
import com.springboot.staffingsystem.service.impl.EmployeeServiceImpl;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 删除员工 （单个多个合并）
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/emp/{ids}")
    public void deleteEmp(@PathVariable("ids") String[] ids){
        List<Integer> del_ids = new ArrayList<Integer>();
        for (String string : ids){
            del_ids.add(Integer.parseInt(string));
        }
        employeeService.deleteBatch(del_ids);
    }

    /**
     * 更新员工
     * @param employee
     * @param request
     * @return
     */
    @PutMapping(value = "/emp/{empId}")
    public void updateEmp(@RequestBody Employee employee){
        employeeService.updateEmp(employee);
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @GetMapping(value = "/emp/{id}")
    public Employee getEmp(@PathVariable("id")Integer id){
        Employee employee = employeeService.getEmp(id);
       return employee;
    }

    /**
     * 检查用户名是否可用
     * @param empName
     * @return
     */
    @RequestMapping("/checkuser")
    @ResponseBody
    public Msg checkuser(@RequestParam("empName")String empName){
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }

        //数据库用户名重复校验
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg", "用户名不可用");
        }

    }


    /**
     * 员工保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     *
     * @return
     */
    @PostMapping(value = "/emp")
    public void saveEmp(@RequestBody Employee employee, HttpServletResponse response){
     /*   Employee employee =new Employee();
        System.out.println(empName);
        System.out.println(gender);
        @RequestParam(value = "empName")String empName, @RequestParam(value = "gender")String gender,
        @RequestParam(value = "email")String email,@RequestParam(value = "dId")Integer dId
        employee.setEmpName(empName);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setdId(dId);*/
//        if (result.hasErrors()){
//            Map<String ,Object> map = new HashMap<>();
//            List<FieldError> errors = result.getFieldErrors();
//            for (FieldError fieldError : errors){
//                System.out.println("错误的字段名："+fieldError.getField());
//                System.out.println("错误信息："+fieldError.getDefaultMessage());
//                map.put(fieldError.getField(),fieldError.getDefaultMessage());
//            }
//            return Msg.fail().add("errorFields",map);
//            }else {
        System.out.println(employee.toString());
            employeeService.saveEmp(employee);
        }
//    }

    @GetMapping("/emps")
    public List<Employee> getEmps(){
        List<Employee> list = employeeService.getAll();
        return list;
    }
}

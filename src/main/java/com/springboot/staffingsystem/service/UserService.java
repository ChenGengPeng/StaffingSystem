package com.springboot.staffingsystem.service;

import com.springboot.staffingsystem.bean.User;

import java.util.List;

public interface UserService {
    //获取所有管理用户
    public List<User> getAll();
    //根据姓名查询用户
    public boolean countByUsernameAndUserpawword(String username, String password);
}

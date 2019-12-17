package com.springboot.staffingsystem.service.impl;

import com.springboot.staffingsystem.bean.User;
import com.springboot.staffingsystem.dao.UserMapper;
import com.springboot.staffingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;
    //获取所有管理用户
    @Override
    public List<User> getAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public boolean countByUsernameAndUserpawword(String username, String password) {
      if (userMapper.countByUsernameAndPasswword(username,password)==1){
          return true;
      }
      return false;
    }

}

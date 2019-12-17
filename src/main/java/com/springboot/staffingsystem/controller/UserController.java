package com.springboot.staffingsystem.controller;

import com.springboot.staffingsystem.bean.Msg;
import com.springboot.staffingsystem.bean.User;
import com.springboot.staffingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Msg login(@Valid User user){
        userService.countByUsernameAndUserpawword(user.getUsername(),user.getPassword());
        return Msg.success();
    }
}

package com.wen.controller;

import com.wen.domain.ResponseResult;
import com.wen.domain.entity.User;
import com.wen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping("/logout")
    public ResponseResult logout(){
        return userService.logout();
    }

}

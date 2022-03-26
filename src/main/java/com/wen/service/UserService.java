package com.wen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.User;

public interface UserService extends IService<User> {
    ResponseResult login(User user);

    ResponseResult logout();
}

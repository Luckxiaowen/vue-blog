package com.wen.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.domain.LoginUser;
import com.wen.domain.ResponseResult;
import com.wen.domain.entity.User;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.exception.SystemException;
import com.wen.mapper.UserMapper;
import com.wen.service.UserService;
import com.wen.utils.JwtUtil;
import com.wen.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (ObjectUtil.isNull(authentication)){
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String token = JwtUtil.createJWT(userId);
        //loginUser存入Redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        Map<String, String> map = new HashMap<>();
        map.put("token",token);
        return new ResponseResult(200,"登陆成功!",map);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer id = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+id);
        return new ResponseResult(200,"退出成功!");
    }
}

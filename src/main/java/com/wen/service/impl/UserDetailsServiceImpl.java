package com.wen.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wen.domain.LoginUser;
import com.wen.domain.entity.User;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.exception.SystemException;
import com.wen.mapper.MenuMapper;
import com.wen.mapper.RoleMapper;
import com.wen.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //根据用户名查询用户
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        if (ObjectUtil.isNull(user)){
            throw new SystemException(AppHttpCodeEnum.LOGIN_ERROR);
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中
        List<String> role = roleMapper.getRoleByUserId(user.getId());
        for (String s : role) {
            s += "ROLE_";
        }

        return new LoginUser(user,role);
    }
}

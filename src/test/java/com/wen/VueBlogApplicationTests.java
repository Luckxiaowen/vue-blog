package com.wen;

import com.wen.mapper.MenuMapper;
import com.wen.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class VueBlogApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void contextLoads() {
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    void menuTest(){
        System.out.println(menuMapper.getPath(1));
    }

    @Test
    void roleTest(){
        System.out.println(roleMapper.getRoleByUserId(1));
    }

}

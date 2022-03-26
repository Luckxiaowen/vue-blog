package com.wen.handler;

import com.alibaba.fastjson.JSON;
import com.wen.domain.ResponseResult;
import com.wen.enums.AppHttpCodeEnum;
import com.wen.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();

        ResponseResult result = new ResponseResult().error(AppHttpCodeEnum.NEED_LOGIN.getCode(),AppHttpCodeEnum.NEED_LOGIN.getMsg());
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}


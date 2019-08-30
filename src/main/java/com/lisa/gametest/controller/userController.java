package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/user")
public class userController {
    @RequestMapping("/login.do")
    public AjaxResult login(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject主体对象
        Subject subject = SecurityUtils.getSubject();
        AjaxResult result = new AjaxResult();
        try {
            // 进行登陆判断
            subject.login(token);
            result.setCode(1);
            result.setInfo(null);
            return result;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
            return result;
        }
    }
}

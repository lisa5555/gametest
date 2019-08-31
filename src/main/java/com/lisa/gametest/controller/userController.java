package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/user")
public class userController {
    @Autowired
    private ITUserService service;
    @RequestMapping("/login.do")
    public AjaxResult login(String username, String password, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        TUser user = service.findByName(username);
        session.setAttribute("user",user);
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

package com.lisa.gametest.controller;


import cn.dsna.util.images.ValidateCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITTestNumberService;
import com.lisa.gametest.service.ITUserService;
import com.lisa.gametest.utils.MD5Utils;
import com.lisa.gametest.vo.KsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// 解决ajax跨域不能访问问题
//@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private ITTestNumberService ns;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private ITUserService service;
    @RequestMapping("/login.do")
    //public Map<String, Object> login(String name, String password, HttpSession session){
    public AjaxResult login(String username, String password,String vercode){
        AjaxResult result = new AjaxResult();
        Map<String, Object> map = new HashMap<>();
        String validateCode = redisTemplate.opsForValue().get("ValidateCode");
        if (validateCode.equals(vercode)){
            // 根据name生成token
            try {
                TUser tUser = service.findByName(username);
                String token = MD5Utils.md5(tUser.getUsername() + "haha");
                map.put("token", token);
                // 将token写道redis中
                redisTemplate.opsForValue().set("token", tUser.getUsername());
                redisTemplate.expire(token, 1800, TimeUnit.SECONDS);
                result.setCode(1);
                result.setInfo(map);
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(0);
                result.setInfo(e.getMessage());
            }
            return result;

        }else {
            result.setCode(0);
            result.setInfo("验证码错误");
            return result;
        }



    }
    @RequestMapping("/createVcode.do")
    public void createVcode(HttpServletResponse response) throws IOException {
        ValidateCode vcode = new ValidateCode(100, 40, 4, 40);
        vcode.createCode();
        System.out.println(vcode.getCode());
        redisTemplate.opsForValue().set("ValidateCode", vcode.getCode());
         vcode.write(response.getOutputStream());
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @RequestMapping("/list.do")
    public Map<String,Object>  show2(Integer page,Integer limit,String typeName) {
        String username = redisTemplate.opsForValue().get("token");
        PageHelper.startPage(page,limit);
        List<KsnInfo> list = ns.findAll2(username,typeName);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }


}

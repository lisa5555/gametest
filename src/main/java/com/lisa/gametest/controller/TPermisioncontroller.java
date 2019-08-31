package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TPermision;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITPermisionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/menu")
public class TPermisioncontroller {
    @Autowired
    private ITPermisionService service;
    @RequestMapping("/list.do")
    public AjaxResult menulist(HttpSession session){
        TUser user = (TUser)session.getAttribute("user");
        AjaxResult result = new AjaxResult();
        try {
            List<TPermision> list = service.findpermisionByName(user.getUid());
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(0);
            result.setInfo(e.getMessage());
        }
        return result;
    }
}

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
import java.util.Map;

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


    @RequestMapping("/findTPermision")
    public AjaxResult findTPermision(Integer pid) {
        TPermision tPermision = service.findTPermision(pid);
        return new AjaxResult(1, tPermision);
    }

    @RequestMapping("/findFirstTPermision")
    public Map<String, Object> findFirst(String searchName, Integer page, Integer limit) {
        Map<String, Object> map = service.findFirstTPermision(page, limit, searchName);
        return map;
    }


    @RequestMapping("/findSecondTPermision")
    public Map<String, Object> findSecond(String searchName,Integer pid, Integer page, Integer limit) {
        Map<String, Object> map = service.findMyPermission(page, limit, pid, searchName);
        return map;
    }


    @RequestMapping("/findAllTPermision")
    public AjaxResult findAll() {
        List<TPermision> list = service.findAll();
        return new AjaxResult(1, list);
    }

    @RequestMapping("/addTPermision")
    public AjaxResult addTPermision(TPermision tPermision) {
        try {
            service.insertTPermision(tPermision);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "添加失败");
        }
    }


    @RequestMapping("/updateTPermision")
    public AjaxResult updateTPermision(TPermision tPermision){
        try {
            service.updateTPermision(tPermision);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "更新失败");
        }
    }

    @RequestMapping("/deleteTPermision")
    public AjaxResult deleteOne(Integer pid) {
        try {
            service.deleteTPermisionById(pid);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "删除失败");
        }
    }


    @RequestMapping("/deleteSomeTPermision")
    public AjaxResult deleteSomeTPermision(String ids) {
        String[] strings = ids.split(",");
        try {
            service.deleteTPermisionByIds(strings);
            return new AjaxResult(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "批量删除失败");
        }
    }


}

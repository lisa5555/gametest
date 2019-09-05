package com.lisa.gametest.controller;


import com.github.pagehelper.Page;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TRole;
import com.lisa.gametest.entity.TUserRole;
import com.lisa.gametest.service.ITRoleService;
import com.lisa.gametest.vo.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/role")
public class TRoleController {
    @Autowired
    private ITRoleService itRoleService;
    /**
     * 查询所有角色信息
     * @return
     *     成功返回 AjaxResult
     */
    @RequestMapping("query.do")

    public AjaxResult findAll() {

        AjaxResult ajaxResult = new AjaxResult();

        try {
            List<TRole> list = itRoleService.findAll();
            ajaxResult.setCode(0);
            ajaxResult.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setInfo(null);
        }
        return ajaxResult;
    }

    /**
     *  分页查询所有数据
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/queryLimit.do")

    public Map<String,Object> findAllByLimit(Integer page, Integer limit){
        List<TRole> list = itRoleService.findAllByLimit(page, limit);
        System.out.println(list);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    /**
     *  分页查询所有数据
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/queryLimit2.do")
    public Map<String,Object> findAllRoleByLimit(Integer page, Integer limit, Integer rid){
        List<RoleInfo> list = itRoleService.findAllRoleByLimit(page, limit,rid);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
    /**
     * 添加角色信息
     * @param id
     * @return
     */
    @RequestMapping("/addUserRole.do")

    public AjaxResult addUserRole(int id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            itRoleService.addUserRole(id);
            ajaxResult.setCode(0);
            ajaxResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setInfo(e.getMessage());
        }
        return ajaxResult;
    }

    /**
     * 添加角色信息
     * @param
     * @return
     */
    @RequestMapping("/add.do")

    public AjaxResult addRole(TRole tRole){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            itRoleService.addRole(tRole);
            ajaxResult.setCode(0);
            ajaxResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setInfo(e.getMessage());
        }
        return ajaxResult;
    }

    /**
     *  查找指定id角色
     */
    @RequestMapping("/queryById.do")

    public AjaxResult queryById(HttpServletRequest request){
        String id = request.getParameter("id");
        AjaxResult asonResult = new AjaxResult();
        try {
            TRole t = itRoleService.queryById(Integer.parseInt(id));
            asonResult.setCode(0);
            asonResult.setInfo(t);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }

        return asonResult;
    }


    @RequestMapping("/updateUserRole.do")

    public AjaxResult updateUserRole(TUserRole ur, HttpServletRequest request){
        String id = request.getParameter("id");
        AjaxResult asonResult = new AjaxResult();
        try {
            ur.setUid(Integer.parseInt(id));
            itRoleService.updateUserRole(ur);
            asonResult.setCode(0);
            asonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }
        return asonResult;
    }

    /**
     * 删除指定id角色
     * @param id
     * @return
     */
    @RequestMapping("/delete.do")

    public AjaxResult deleteById(Integer id){
        AjaxResult asonResult = new AjaxResult();
        try {
            itRoleService.deleteById(id);
            asonResult.setCode(0);
            asonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }
        return asonResult;
    }


}

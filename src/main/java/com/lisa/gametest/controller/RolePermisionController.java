package com.lisa.gametest.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TPermision;
import com.lisa.gametest.entity.TRole;
import com.lisa.gametest.entity.TRolePermision;
import com.lisa.gametest.service.ITPermisionService;
import com.lisa.gametest.service.ITRolePermisionService;
import com.lisa.gametest.service.ITRoleService;
import com.lisa.gametest.vo.PersionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/rolepermision")
public class RolePermisionController {

    @Autowired
    private ITRolePermisionService rpservice;

    @Autowired
    private ITPermisionService permisionService;

    @Autowired
    private ITRoleService roleService;


    /**
     * 查询所有角色权限信息
     * @return
     *     成功返回
     */
    @RequestMapping("query.do")

    public Map<String,Object> findAll(Integer page, Integer limit) {
        List<TRole> list = roleService.findAllByLimit(page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
    /**
     * 查询所有角色权限信息
     * @return
     *     成功返回
     */
    @RequestMapping("query2.do")

    public Map<String,Object> findPersionById(Integer rid,Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<PersionInfo> list = rpservice.findPersionById(rid);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    /**
     * 查询所有角色权限信息
     * @return
     *     成功返回
     */
    @RequestMapping("queryresourcename.do")

    public AjaxResult findAll() {
        List<TPermision> list = permisionService.findAll();

        return new AjaxResult(1, list);
    }

    /**
     * 删除指定id用户
     * @param rid,pid
     * @return
     */
    @RequestMapping("/delete.do")

    public AjaxResult deleteById(Integer rid, Integer pid){
        AjaxResult asonResult = new AjaxResult();
        try {
            if (rid != 1) {
                rpservice.deleteById(rid, pid);
                asonResult.setCode(0);
                asonResult.setInfo(null);
            } else {
                asonResult.setCode(1);
                asonResult.setInfo("管理员无法删除自己权限");
            }
        } catch (Exception e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }
        return asonResult;
    }

    @RequestMapping("/add.do")

    public AjaxResult add(Integer rid, Integer pid){
        AjaxResult asonResult = new AjaxResult();
        try {
            rpservice.add(rid,pid);
            asonResult.setCode(1);
            asonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            asonResult.setCode(0);
            asonResult.setInfo(e.getMessage());
        }
        return asonResult;
    }

}

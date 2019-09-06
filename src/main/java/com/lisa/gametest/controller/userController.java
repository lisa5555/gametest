package com.lisa.gametest.controller;

import com.github.pagehelper.Page;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.entity.TUserRole;
import com.lisa.gametest.service.ITRoleService;
import com.lisa.gametest.service.ITUserRoleService;
import com.lisa.gametest.service.ITUserService;
import com.lisa.gametest.utils.MD5Utils;
import com.lisa.gametest.vo.TUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class userController {
    @Autowired
    private ITUserService service;
    @Autowired
    private ITRoleService urservice;
    @Autowired
    private ITRoleService roleservice;
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

    /**
     * 查询所有用户信息
     * @return
     *     成功返回 AjaxResult
     */
    @RequestMapping("query.do")

    public AjaxResult findAll() {

        AjaxResult ajaxResult = new AjaxResult();

        try {
            List<TUser> list = service.findAll();
            ajaxResult.setCode(0);
            ajaxResult.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setInfo(null);
        }
        return ajaxResult;
    }

    @RequestMapping("/query2.do")
    public Map<String,Object> findByCondition(Integer page,Integer limit,String username,String name,String sex,Integer state){
        List<TUser> list = service.findAll1(page, limit, username, name, sex,state);
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
    @RequestMapping("/queryLimit.do")

    public Map<String,Object> findAllByLimit(Integer page, Integer limit){
        List<TUser> list = service.findAllByLimit(page, limit);
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

    public Map<String,Object> findAllByLimit2(Integer page, Integer limit){
        List<TUserInfo> list = service.findAllByLimit2(page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    /**
     * 添加用户信息
     * @param tUser
     * @return
     */
    @RequestMapping("/add.do")

    public AjaxResult add(TUser tUser){
        AjaxResult ajaxResult = new AjaxResult();
        String password = tUser.getPassword();
        String s = MD5Utils.md5(password);
        tUser.setPassword(s);
        try {
            service.add(tUser);
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
     *  查找指定id用户
     */
    @RequestMapping("/queryById.do")

    public AjaxResult queryById(HttpServletRequest request){
        String id = request.getParameter("id");
        AjaxResult asonResult = new AjaxResult();
        try {
            TUser s = service.queryById(Integer.parseInt(id));
            asonResult.setCode(0);
            asonResult.setInfo(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }

        return asonResult;
    }

    /**
     * 修改指定用户信息
     * @param tUser
     * @param request
     * @return
     */
    @RequestMapping("/update.do")

    public AjaxResult update(TUser tUser, HttpServletRequest request){
        String id = request.getParameter("id");
        AjaxResult asonResult = new AjaxResult();
        try {
            tUser.setUid(Integer.parseInt(id));
            service.update(tUser);
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
     * 删除指定id用户
     * @param id
     * @return
     */
    @RequestMapping("/delete.do")

    public AjaxResult deleteById(Integer id){
        AjaxResult asonResult = new AjaxResult();
        try {
            service.deleteById(id);
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
     * 审核指定id用户
     * @param id
     * @return
     */
    @RequestMapping("/check.do")

    public AjaxResult checkById(Integer id){
        AjaxResult asonResult = new AjaxResult();
        try {
            service.checkById(id);
            urservice.addUserRole(id);
            asonResult.setCode(0);
            asonResult.setInfo(null);
        } catch (Exception e) {
            e.printStackTrace();
            asonResult.setCode(1);
            asonResult.setInfo(e.getMessage());
        }
        return asonResult;
    }


//    @RequestMapping("/deleteSomeTUser")
//    public AjaxResult deleteSomeTUser(String ids) {
//        String[] strings = ids.split(",");
//        try {
//            service.deleteTUserByIds(strings);
//            return new AjaxResult(1, null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new AjaxResult(0, "批量删除失败");
//        }
//    }


}

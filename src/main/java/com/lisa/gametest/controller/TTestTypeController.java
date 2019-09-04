package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.service.ITTestTypeService;
import com.lisa.gametest.vo.MyTypeProblems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TTestType")
public class TTestTypeController {

    @Autowired
    private ITTestTypeService itTestTypeService;

    /**
     * 添加科目
     * @param
     * @return
     */
    @RequestMapping("/addTTestType")
    @ResponseBody
    public AjaxResult addTTestType(String typeName) {

        TTestType testType = itTestTypeService.findByName(typeName);
        if (testType == null) {
            try {
                itTestTypeService.insertTTestType(typeName);
            } catch (Exception e) {
                return new AjaxResult(0,"添加失败");
            }
            return new AjaxResult(1,null);
        } else {
            return new AjaxResult(2,"该课程已存在");
        }
    }


    /**
     * 根据id查找课程
     * @param tid
     * @return
     */
    @RequestMapping("/findTTestType")
    @ResponseBody
    public AjaxResult queryTTestType(Integer tid) {
        TTestType tTestType = itTestTypeService.findById(tid);
        return new AjaxResult(1,tTestType);
    }


    /**
     * 前端展示
     * @param page
     * @param limit
     * @param searchName
     * @return
     */
    @RequestMapping("/findBySearch")
    @ResponseBody
    public Map<String,Object> findBySearch(Integer page, Integer limit, String searchName) {
        Map<String, Object> map = itTestTypeService.selectBySearch(page, limit, searchName);
        return map;
    }


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAllTTestType")
    @ResponseBody
    public AjaxResult findAllTTestType() {
        List<TTestType> list = itTestTypeService.findAll();
        return new AjaxResult(1, list);
    }


    /**
     * 导入试题展示页面
     * @return
     */
    @RequestMapping("/listMyTTestType")
    @ResponseBody
    public Map<String, Object> listTTestType(){
        Map<String, Object> map = new HashMap<>();
        List<TTestType> list = itTestTypeService.findAll();
        map.put("data", list);
        map.put("code", 0);
        return map;
    }


    /**
     * 查询课程为tid的各种题目的数量
     * @param tid
     * @return
     */
    @RequestMapping("/findTypeProblems")
    @ResponseBody
    public Map<String, Object> findTypeProblems(Integer tid, Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        List<MyTypeProblems> list = itTestTypeService.findTypeProblem(tid);
        map.put("data", list);
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }


    /**
     * 根据id删除课程
     * @param tid
     * @return
     */
    @RequestMapping("/deleteTTestType")
    @ResponseBody
    public AjaxResult deleteTTestType(Integer tid){
        try {
            itTestTypeService.deleteTTestType(tid);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            return new AjaxResult(0,"删除失败");
        }
    }


    /**
     * 批量删除
     * @param string
     * @return
     */
    @RequestMapping("/deleteSomeTTestType")
    @ResponseBody
    public AjaxResult deleteSomeTTestType(String string){
        String[] array = string.split(",");

        try {
            itTestTypeService.deleteTTestTypeByIds(array);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0, "批量删除失败");
        }
    }


    /**
     * 查找所有课程信息
     * @param page
     * @param limit
     * @param searchName
     * @return
     */
    @RequestMapping("/listTTestType")
    @ResponseBody
    public Map<String, Object> queryByTid(Integer page, Integer limit, String searchName){
        Map<String, Object> map = itTestTypeService.selectBySearch(page, limit, searchName);
        return map;
    }


    /**
     * 更新课程
     * @param tTestType
     * @return
     */
    @RequestMapping("/updateTTestType")
    @ResponseBody
    public AjaxResult updateTTestType(TTestType tTestType) {
        TTestType testType = itTestTypeService.findByName(tTestType.getTypeName());
        if (testType == null) {
            try {
                itTestTypeService.updateTTestType(tTestType);
                return new AjaxResult(1,null);
            } catch (Exception e) {
                e.printStackTrace();
                return new AjaxResult(0,"更新失败");
            }
        } else {
            return new AjaxResult(2,"该课程已存在");
        }

    }

}

package com.lisa.gametest.controller;

import com.github.pagehelper.Page;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TOverPaper;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITOverPaperService;
import com.lisa.gametest.service.ITTestTypeService;
import com.lisa.gametest.service.ITUserService;
import com.lisa.gametest.vo.overPaperInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/overPaper")
public class overPaperController {

    @Autowired
    private ITOverPaperService itOverPaperService;

    @Autowired
    private ITTestTypeService itTestTypeService;

    @Autowired
    private ITUserService itUserService;


    /**
     *  查询所有方法
     * @param typeName 学科
     * @param name     学生姓名
     * @param page
     * @param limit
     * @return          返回JSON格式数据
     */
    @ResponseBody
    @RequestMapping("/query.do")
    public Map<String,Object> findAllTOverPaper(String typeName,Integer state,String name,Integer page, Integer limit) {
        Map<String, Object> map = itOverPaperService.findAllTOverPaper(typeName,state,name,page, limit);

        return map;
    }

    /**
     * 查询所有
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAllTTestType")
    public AjaxResult findAllTTestType() {
        List<TTestType> list = itTestTypeService.findAll();
        return new AjaxResult(1,list);
    }


    /**
     * 查询所有用户信息
     * @return
     *     成功返回 AjaxResult
     */
    @ResponseBody
    @RequestMapping("query2.do")
    public AjaxResult findAll() {

        AjaxResult ajaxResult = new AjaxResult();

        try {
            List<TUser> list = itUserService.findAll();
            ajaxResult.setCode(1);
            ajaxResult.setInfo(list);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult.setCode(0);
            ajaxResult.setInfo(null);
        }
        return ajaxResult;
    }


    @ResponseBody
    @RequestMapping("/findByState.do")
    public AjaxResult findByState(Integer oid){
        AjaxResult result = new AjaxResult();

        try {
            List<overPaperInfo> list = itOverPaperService.findByState(oid);
            result.setCode(1);
            result.setInfo(list);
        } catch (Exception e) {
            result.setCode(0);
            result.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteById.do")
    public AjaxResult deleteById(Integer oid) {
        AjaxResult result = new AjaxResult();

        try {
            itOverPaperService.deleteById(oid);
            result.setCode(1);
            result.setInfo(null);
        } catch (Exception e) {
            result.setCode(0);
            result.setInfo(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/deleteAll.do")
    public AjaxResult deleteAll(String ids) {

        AjaxResult result = new AjaxResult();

        String[] oidArr = ids.split(",");
        int[] id = new int[oidArr.length];
        for (int i = 0; i <oidArr.length;i++ ){
            id[i] = Integer.parseInt(oidArr[i]);
        }

        itOverPaperService.deleteAll(id);

        return new AjaxResult(1, null);

    }

}

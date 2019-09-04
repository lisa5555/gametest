package com.lisa.gametest.controller;

import com.github.pagehelper.Page;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TTestType;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITScoreService;
import com.lisa.gametest.service.ITTestTypeService;
import com.lisa.gametest.service.ITUserService;
import com.lisa.gametest.vo.voScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/total")
public class TScoreController {

    @Autowired
    private ITScoreService itScoreService;

    @Autowired
    private ITTestTypeService itTestTypeService;

    @Autowired
    private ITUserService itUserService;


    /**
     * 查询所有
     * @param typeName
     * @param name
     * @param page
     * @param limit
     * @return
     */
   @ResponseBody
   @RequestMapping("/query.do")
   public Map<String,Object> findAllScore(String typeName,String name,Integer page, Integer limit){
       List<voScore> list = itScoreService.findAllScore(typeName, name, page, limit);

       long total = ((Page) list).getTotal();
       HashMap<String, Object> map = new HashMap<>();
       map.put("code", 0);
       map.put("msg", "");
       map.put("count", total);
       map.put("data", list);

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

    /**
     * 根据ID删除对象
     * @param sid
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteById.do")
    private AjaxResult deleteById(Integer sid) {
        AjaxResult result = new AjaxResult();

        try {
            itScoreService.deleteById(sid);
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
    @RequestMapping("/findByTypeName")
    public Map<String,List> findByTypeName(String typeName) {
        List<voScore> list = itScoreService.findAllTypeName(typeName);

        List<String> TN = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        for (voScore voScore : list) {
            TN.add(voScore.getTypeName());
            total.add(voScore.getTotal());
        }

        Map<String, List> map = new HashMap<>();
        map.put("TN",TN);
        map.put("total",total);

        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteAll.do")
    public AjaxResult deleteAll(String ids) {

        String[] sidArr = ids.split(",");
        int[] id = new int[sidArr.length];
        for (int i = 0; i <sidArr.length;i++ ){
            id[i] = Integer.parseInt(sidArr[i]);
        }

        itScoreService.deleteAll(id);

        return new AjaxResult(1, null);

    }
}

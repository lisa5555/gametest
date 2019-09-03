package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.common.ExcelUtils;
import com.lisa.gametest.entity.TAnswer;
import com.lisa.gametest.service.ITAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/TAnswer")
public class TAnswerController {

    @Autowired
    private ITAnswerService itAnswerService;

    /**
     * 插入简答题
     * @param tAnswer
     * @return
     */
    @RequestMapping("/addTAnswer")
    @ResponseBody
    public AjaxResult addAnswer(TAnswer tAnswer){
        try{
            itAnswerService.insert(tAnswer);
        }catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"添加失败");
        }
        return new AjaxResult(1,null);
    }

    /**
     * 批量导入简答题
     * @param upfile
     * @return
     */
    @RequestMapping("/importAnswer")
    @ResponseBody
    public AjaxResult importExcel(@RequestParam MultipartFile upfile){

        // 获取上传文件的输入流对象
        try {
            List<Map<String, Object>> list = ExcelUtils.readExcel(upfile);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(list);
            // 将json格式的字符串转为指定类型的对象
            List<TAnswer> tAnswerList = objectMapper.readValue(jsonStr, new TypeReference<List<TAnswer>>() {});

            itAnswerService.insertSomeAnswer(tAnswerList);

        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"导入失败");
        }

        return new AjaxResult(1,null);
    }

    /**
     * 根据id删除
     * @param aid
     * @return
     */
    @RequestMapping("/deleteTAnswer")
    @ResponseBody
    public AjaxResult deleteTAnswer(Integer aid){

        itAnswerService.deleteByTAnswerId(aid);
        return new AjaxResult(1,null);
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/deleteSomeTAnswer")
    @ResponseBody
    public AjaxResult deleteSomeTAnswer(String ids) {
        String[] array = ids.split(",");
        try{
            itAnswerService.deleteTAnswerByIds(array);
            return new AjaxResult(1,null);
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(0,"批量删除失败");
        }
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping("/findTAnswer")
    @ResponseBody
    public AjaxResult queryTAnswer(Integer id) {
        TAnswer tAnswer = itAnswerService.selectTAnswerById(id);
        return new AjaxResult(1,tAnswer);
    }


    /**
     * 根据课程id查找对应的所有简答题
     * @param tid
     * @return
     */
    @RequestMapping("/listTAnswer")
    @ResponseBody
    public Map<String, Object> selectSomeTAnswer(Integer tid,String searchName,Integer score,Integer page, Integer limit){
        Map<String, Object> map = itAnswerService.selectBySearch(page, limit, tid, searchName, score);
        return map;
    }


    @RequestMapping("/updateTAnswer")
    @ResponseBody
    public AjaxResult updateTAnswer(TAnswer tAnswer) {
        try {
            itAnswerService.updateTAnswer(tAnswer);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"更新失败");
        }

    }
}

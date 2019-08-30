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
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult deleteTanswer(Integer aid){

        itAnswerService.deleteByTAnswerId(aid);
        return new AjaxResult(1,null);
    }


    /**
     * 批量删除
     * @param string
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult deleteSomeTAnswer(String string) {
        String[] array = string.split(",");
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
     * @param aid
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult queryTAnswer(Integer aid) {
        TAnswer tAnswer = itAnswerService.selectTAnswerById(aid);
        return new AjaxResult(1,tAnswer);
    }


    /**
     * 根据课程id查找对应的所有简答题
     * @param tid
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult selectSomeTAnswer(Integer tid){
        List<TAnswer> tAnswerList = itAnswerService.selectByTid(tid);
        return new AjaxResult(1,tAnswerList);
    }


    @RequestMapping("/updateTAswer")
    @ResponseBody
    public AjaxResult updateTAswer(TAnswer tAnswer) {
        try {
            itAnswerService.updateTAnswer(tAnswer);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"更新失败");
        }

    }
}

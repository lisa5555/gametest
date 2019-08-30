package com.lisa.gametest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.common.ExcelUtils;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.service.ITChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Controller
public class TChooseController {

    /**
     * 添加选择题
     */
    @Autowired
    private ITChooseService itChooseService;

    @RequestMapping("/addTchoose")
    @ResponseBody
    public AjaxResult addTchoose(TChoose tChoose){
        try{
            itChooseService.insert(tChoose);
        }catch (Exception e) {
            return new AjaxResult(0,"添加失败");
        }
        return new AjaxResult(1,null);
    }

    /**
     * 批量导入选择题
     * @param upfile
     * @return
     */
    @RequestMapping("/importTchoose")
    @ResponseBody
    public AjaxResult importExcel(@RequestParam MultipartFile upfile){

        // 获取上传文件的输入流对象
        try {
            List<Map<String, Object>> list = ExcelUtils.readExcel(upfile);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(list);
            // 将json格式的字符串转为指定类型的对象
            List<TChoose> tChooseList = objectMapper.readValue(jsonStr, new TypeReference<List<TChoose>>() {});

            itChooseService.insertSomeChoose(tChooseList);

        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"导入失败");
        }

        return new AjaxResult(1,null);
    }

    /**
     * 根据Tchoose的id查找
     * @param id
     * @return
     */
    @RequestMapping("/findTChoose")
    @ResponseBody
    public AjaxResult findByChooseId(Integer id) {

        TChoose tChoose = itChooseService.selectTChooseById(id);
        return new AjaxResult(1,tChoose);
    }

    /**
     * 根据Tchoose的id删除
     * @param cid
     * @return
     */
    @RequestMapping("/deleteTChoose")
    @ResponseBody
    public AjaxResult deleteTChoose(Integer cid) {
        try {
            itChooseService.deleteByTChooseId(cid);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"删除失败");
        }
    }

    /**
     * 批量删除
     * @param string
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult deleteSomeTChoose(String string) {
        //根据传入的字符串进行切割，得到字符串数组
        String[] arr = string.split(",");

        try {
            itChooseService.deleteTChooseByIds(arr);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            return new AjaxResult(0,"批量删除失败");
        }
    }

    /**
     * 更新选择题
     * @param tChoose
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult updateTChoose(TChoose tChoose) {
        try {
            itChooseService.updateTChoose(tChoose);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            return new AjaxResult(0,"更新失败");
        }
    }


    /**
     * 根据选择题id进行查询
     * @param id
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult queryChoose(Integer id){
        TChoose tChoose = itChooseService.selectTChooseById(id);
        return new AjaxResult(1,tChoose);
    }


    /**
     * 根据tid进行查询
     * @param tid
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public AjaxResult queryByTid(Integer tid){
        List<TChoose> tChooseList = itChooseService.selectByTid(tid);
        return new AjaxResult(1,tChooseList);

    }

}
package com.lisa.gametest.controller;

import com.lisa.gametest.common.AjaxResult;
import com.lisa.gametest.entity.TKuinfo;
import com.lisa.gametest.entity.TUser;
import com.lisa.gametest.service.ITKuinfoService;
import com.lisa.gametest.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/TKuinfo")
public class TKuinfoController {

    @Autowired
    private ITKuinfoService itKuinfoService;

    @Autowired
    private ITUserService itUserService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 报名考试
     * @param kid 考场id
     * @return
     */
    @RequestMapping("/addTKuinfo")
    public AjaxResult addTKuinfo(Integer kid) {
        String username = redisTemplate.opsForValue().get("token");

        TUser user = itUserService.findByName(username);
        TKuinfo tKuinfo = new TKuinfo();
        tKuinfo.setKid(kid);
        tKuinfo.setUid(user.getUid());
        try {
            itKuinfoService.insertTKuinfo(tKuinfo);
            return new AjaxResult(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(0,"添加失败");
        }

    }


    


}

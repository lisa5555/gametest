package com.lisa.gametest.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lisa.gametest.OverPaperVo.PaperAnswerInfo;
import com.lisa.gametest.dao.*;
import com.lisa.gametest.entity.TChoose;
import com.lisa.gametest.entity.TJudge;
import com.lisa.gametest.entity.TOverPaper;
import com.lisa.gametest.entity.TPaper;
import com.lisa.gametest.service.ITOverPaperService;

import com.lisa.gametest.vo.overPaperInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TOverPaperServiceImpl implements ITOverPaperService {

    @Autowired(required = false)
    private TOverPaperMapper tOverPaperMapper;
    @Autowired(required = false)
    private TPaperMapper tPaperMapper;
    @Autowired(required = false)
    private TChooseMapper tChooseMapper;
    @Autowired(required = false)
    private TAnswerMapper tAnswerMapper;
    @Autowired(required = false)
    private TJudgeMapper tJudgeMapper;

    @Override
    public List<overPaperInfo> findAllTOverPaper(String typeName,String name,Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<overPaperInfo> list = tOverPaperMapper.findAllTP(typeName,name);
        return list;
    }

    @Override
    public List<overPaperInfo> findByState(Integer oid) {
        List<overPaperInfo> list = tOverPaperMapper.findByState(oid);
        return list;
    }

    @Override
    public void deleteById(Integer oid) {
        tOverPaperMapper.deleteById(oid);
    }

    @Override
    public Integer deleteAll(int[] oidArr) {
        return tOverPaperMapper.deleteAll(oidArr);
    }

    @Override
    public void correctionPaper(Integer qid, Integer uid, List<PaperAnswerInfo> list) {

        TOverPaper OverPaper = tOverPaperMapper.findOid(uid, qid);
        TPaper tPaper = tPaperMapper.findPaperById(qid);
        int chooseScore = 0;
        int judgeScore = 0;
        int i,j;
        String choose = tPaper.getChoose();
        String judge = tPaper.getJudge();

        String[] cArr = choose.split(",");
        String[] aArr = judge.split(",");
        try {
            if (cArr.length != 0) {
                for (i = 0; i <= cArr.length; i++) {
                    TChoose tChoose = tChooseMapper.selectTChooseById(Integer.parseInt(cArr[i]));
                    if (tChoose.getCorrect().equals(list.get(i).getAnswer())) {
                        chooseScore += tChoose.getScore();
                    }
                }
            }

            if (aArr.length != 0) {
                i = cArr.length + 1;
                for (j = 0; j <= aArr.length; j++) {
                    TJudge tJudge = tJudgeMapper.selectTJudgeById(Integer.parseInt(aArr[j]));
                    if (tJudge.getCorrect().equals(list.get(i++).getAnswer())) {
                        judgeScore += tJudge.getScore();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        chooseScore += judgeScore;
        OverPaper.setScore(chooseScore);

        try {
            tOverPaperMapper.updateTOverPaper(OverPaper);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



//    @Override
//    public List<TOverPaper> findAllTOverPaper() {
//        return tOverPaperMapper.findAllTOverPaper();
//    }

}

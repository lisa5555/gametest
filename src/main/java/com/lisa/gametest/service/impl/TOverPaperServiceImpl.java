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

        int size = 0;

        TOverPaper overPaper = new TOverPaper();
        overPaper.setPid(qid);
        overPaper.setUid(uid);
        overPaper.setState(0);


        int chooseScore = 0;
        int judgeScore = 0;
        int i,j;

        List<TChoose> chooseList = tChooseMapper.findTChooseByPid(qid);
        for (i = 0; i <= chooseList.size(); i++) {

            PaperAnswerInfo paperAnswer = list.get(size);
            TChoose tChoose = chooseList.get(i);

            if (paperAnswer != null){
                int id = paperAnswer.getId();
                id--;

                if (paperAnswer.getId() == 0) {
                    if (paperAnswer.getAnswer().equals(tChoose.getCorrect())) {
                        chooseScore += tChoose.getScore();
                    }
                    size++;
                } else if (id == i) {
                    if (paperAnswer.getAnswer().equals(tChoose.getCorrect())) {
                        chooseScore += tChoose.getScore();
                    }
                    size++;
                }
            }
        }

        List<TJudge> judgeList = tJudgeMapper.findTJudgeByPid(qid);
        int c = chooseList.size();

        for (j = 0; j <= judgeList.size(); j++){
            c += j;
            PaperAnswerInfo paperAnswer = list.get(size);
            TJudge tjudge = judgeList.get(j);
            if (paperAnswer != null) {

                int id = paperAnswer.getId();
                id--;

                if (paperAnswer.getId() == 0) {
                    if (paperAnswer.getAnswer().equals(tjudge.getCorrect())) {
                        judgeScore += tjudge.getScore();
                    }
                    size++;
                } else if (c == id) {
                    if (paperAnswer.getAnswer().equals(tjudge.getCorrect())) {
                        judgeScore += tjudge.getScore();
                    }
                    size++;
                }
            }
        }


        chooseScore += judgeScore;
        overPaper.setScore(chooseScore);

        try {
            tOverPaperMapper.addTOverPaper(overPaper);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

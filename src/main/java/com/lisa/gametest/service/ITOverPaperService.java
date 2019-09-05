package com.lisa.gametest.service;


import com.lisa.gametest.OverPaperVo.PaperAnswerInfo;
import com.lisa.gametest.entity.TOverPaper;
import com.lisa.gametest.vo.overPaperInfo;

import java.util.List;
import java.util.Map;

public interface ITOverPaperService {

    //public List<TOverPaper> findAllTOverPaper();

    //public List<> findAllTOverPaper(String username, String typeName ,Integer page, Integer limit);
    public List<overPaperInfo> findAllTOverPaper(String typeName, String name, Integer page, Integer limit);

//    public TOverPaper findOid(Integer qid, Integer uid);

    public List<overPaperInfo> findByState(Integer oid);

    public void deleteById(Integer oid);

    public Integer deleteAll(int[] oidArr);

    public void correctionPaper(Integer qid, Integer uid, List<PaperAnswerInfo> list, String answerString);

}

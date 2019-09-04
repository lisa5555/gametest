package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TChoose;

import com.lisa.gametest.vo.MyChoose;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TChooseMapper {

    int deleteByTChooseId(Integer cid);

    int deleteTChooseByIds(String[] array);

    int insertTChoose(TChoose tChoose);

    int insertSomeChoose(List<TChoose> list);

    int updateTChoose(TChoose tChoose);

    int findTChooseCount(Integer tid);

    TChoose selectTChooseById(Integer cid);

    List<Integer> createTChooseExams(@Param("tid") Integer tid, @Param("cNum") Integer cNum);

    List<MyChoose> selectBySearch(@Param("tid") Integer tid, @Param("searchName") String searchName, @Param("score") Integer score);

}
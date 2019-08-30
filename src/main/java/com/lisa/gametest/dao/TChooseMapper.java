package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TChoose;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TChooseMapper {

    int deleteByTChooseId(Integer cid);

    int deleteTChooseByIds(String[] array);

    int insert(TChoose tChoose);

    int insertSomeChoose(List<TChoose> list);

    int updateTChoose(TChoose tChoose);

    List<TChoose> selectByTid(Integer tid);

    TChoose selectTChooseById(Integer cid);


}
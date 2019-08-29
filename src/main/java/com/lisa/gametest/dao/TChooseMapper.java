package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TChoose;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TChooseMapper {
    int countByExample(TChoose example);

    int deleteByExample(TChoose example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TChoose record);

    int insertSelective(TChoose record);

    List<TChoose> selectByExample(TChoose example);

    TChoose selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TChoose record, @Param("example") TChoose example);

    int updateByExample(@Param("record") TChoose record, @Param("example") TChoose example);

    int updateByPrimaryKeySelective(TChoose record);

    int updateByPrimaryKey(TChoose record);
}
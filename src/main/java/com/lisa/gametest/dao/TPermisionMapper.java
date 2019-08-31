package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TPermision;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPermisionMapper {
    public List<TPermision> findpermisionByName(Integer uid);

}
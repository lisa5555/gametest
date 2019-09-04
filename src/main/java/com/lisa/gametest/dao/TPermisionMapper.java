package com.lisa.gametest.dao;

import com.lisa.gametest.entity.TPermision;

import com.lisa.gametest.vo.MyPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPermisionMapper {
    public List<TPermision> findpermisionByName(Integer uid);

    List<TPermision> findAllPermision();

    TPermision findTPermision(Integer pid);

    List<MyPermission> findMyPermission(@Param("pid") Integer pid, @Param("searchName") String searchName);

    List<TPermision> findFirstTPermision(String searchName);

    List<TPermision> findSecondTPermision(@Param("pid") Integer pid, @Param("searchName") String searchName);

    int insertTPermision(TPermision tPermision);

    int updateTPermision(TPermision tPermision);

    int deleteTPermisionById(Integer pid);

    int deleteTPermisionByIds(String[] ids);
}
package com.lisa.gametest.service;


import com.lisa.gametest.entity.TPermision;

import java.util.List;

public interface ITPermisionService {
    public List<TPermision> findpermisionByName(Integer uid);
}

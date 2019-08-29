package com.lisa.gametest.service;


import com.lisa.gametest.entity.TUser;

import java.util.List;

public interface ITUserService {
    public TUser findByName(String name);
}

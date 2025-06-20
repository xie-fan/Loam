package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.mapper.UserMapper;
import org.loam.system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

}

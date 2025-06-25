package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.bean.entity.User;
import org.loam.system.mapper.UserMapper;
import org.loam.system.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getList(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteById(id);
    }
}

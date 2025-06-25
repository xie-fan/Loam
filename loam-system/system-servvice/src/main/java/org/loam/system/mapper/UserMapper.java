package org.loam.system.mapper;

import org.loam.system.bean.entity.User;

import java.util.List;

public interface UserMapper {

    User selectById(int id);

    List<User> selectList(User user);

    void insertUser(User user);

    void updateUser(User user);

    void deleteById(int id);
}

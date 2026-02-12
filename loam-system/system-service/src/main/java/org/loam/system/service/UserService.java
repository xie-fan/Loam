package org.loam.system.service;

import org.loam.system.bean.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User getUserByAccount(String username);

    List<User> getList(User user);

    User insertUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getListByPage(User user, int pageNum, int pageSize);
}

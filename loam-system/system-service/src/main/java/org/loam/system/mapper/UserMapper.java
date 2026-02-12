package org.loam.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.loam.system.bean.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectById(Long id);

    User selectByAccount(String account);

    List<User> selectList(User user);

    void insertUser(User user);

    void updateUser(User user);

    void deleteById(Long id);
}

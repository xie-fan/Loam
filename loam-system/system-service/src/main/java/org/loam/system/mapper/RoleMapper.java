package org.loam.system.mapper;

import org.loam.system.bean.entity.Role;

import java.util.List;

public interface RoleMapper {

    Role selectById(Long id);

    List<Role> selectList(Role role);

    void insertRole(Role role);

    void updateRole(Role role);

    void deleteById(Long id);
}

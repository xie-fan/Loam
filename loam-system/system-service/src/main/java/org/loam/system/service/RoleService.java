package org.loam.system.service;

import org.loam.system.bean.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRole(int id);

    List<Role> getList(Role role);

    Role insertRole(Role role);

    Role updateRole(Role role);

    void deleteRole(int id);

    List<Role> getListByPage(Role role, int pageNum, int pageSize);
}
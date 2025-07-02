package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.bean.entity.Role;
import org.loam.system.mapper.RoleMapper;
import org.loam.system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role getRole(int id) {
        return roleMapper.selectById(id);
    }

    @Override
    public List<Role> getList(Role role) {
        return roleMapper.selectList(role);
    }

    @Override
    public Role insertRole(Role role) {
        roleMapper.insertRole(role);
        return role;
    }

    @Override
    public Role updateRole(Role role) {
        roleMapper.updateRole(role);
        return role;
    }

    @Override
    public void deleteRole(int id) {
        roleMapper.deleteById(id);
    }

    @Override
    public List<Role> getListByPage(Role role, int pageNum, int pageSize) {
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize);
        return roleMapper.selectList(role);
    }
}
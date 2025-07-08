package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.bean.entity.Department;
import org.loam.system.mapper.DepartmentMapper;
import org.loam.system.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartment(int id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public List<Department> getList(Department department) {
        return departmentMapper.selectList(department);
    }

    @Override
    public Department insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
        return department;
    }

    @Override
    public void deleteDepartment(int id) {
        departmentMapper.deleteById(id);
    }

    @Override
    public List<Department> getListByPage(Department department, int pageNum, int pageSize) {
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize);
        return departmentMapper.selectList(department);
    }
}
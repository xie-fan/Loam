package org.loam.system.mapper;

import org.loam.system.bean.entity.Department;

import java.util.List;

public interface DepartmentMapper {

    Department selectById(int id);

    List<Department> selectList(Department department);

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    void deleteById(int id);
}
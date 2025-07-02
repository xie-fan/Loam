package org.loam.system.service;

import org.loam.system.bean.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartment(int id);

    List<Department> getList(Department department);

    Department insertDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(int id);

    List<Department> getListByPage(Department department, int pageNum, int pageSize);
}
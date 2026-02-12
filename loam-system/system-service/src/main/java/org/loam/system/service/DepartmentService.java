package org.loam.system.service;

import org.loam.system.bean.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartment(Long id);

    List<Department> getList(Department department);

    Department insertDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(Long id);

    List<Department> getListByPage(Department department, int pageNum, int pageSize);
}

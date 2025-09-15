package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Department;
import org.loam.system.remote.factory.DepartmentCallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "departmentRemoteService", fallbackFactory = DepartmentCallBackFactory.class)
public interface DepartmentRemoteService {

    @GetMapping("/{id}")
    DataSet<Department> getDepartment(@PathVariable int id);

    @GetMapping("/list")
    DataSet<List<Department>> getList(Department department);

    @GetMapping("/listByPage")
    DataSet<List<Department>> getListByPage(Department department, int pageNum, int pageSize);

    @PostMapping
    DataSet<Department> insertDepartment(@RequestPart Department department);

    @PutMapping
    DataSet<Department> updateDepartment(@RequestPart Department department);

    @DeleteMapping("/{id}")
    Message deleteDepartment(@PathVariable int id);

}
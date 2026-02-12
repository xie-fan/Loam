package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Department;
import org.loam.system.remote.factory.DepartmentCallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "system-service", path = "/system/department", fallbackFactory = DepartmentCallBackFactory.class)
public interface DepartmentRemoteService {

    @GetMapping("/{id}")
    DataSet<Department> getDepartment(@PathVariable Long id);

    @GetMapping("/list")
    DataSet<List<Department>> getList(@SpringQueryMap Department department);

    @GetMapping("/listByPage")
    DataSet<List<Department>> getListByPage(@SpringQueryMap Department department,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    DataSet<Department> insertDepartment(@RequestBody Department department);

    @PutMapping
    DataSet<Department> updateDepartment(@RequestBody Department department);

    @DeleteMapping("/{id}")
    Message deleteDepartment(@PathVariable Long id);

}

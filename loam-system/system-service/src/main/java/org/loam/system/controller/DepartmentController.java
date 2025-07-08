package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.database.utils.PageUtils;
import org.loam.system.bean.entity.Department;
import org.loam.system.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public DataSet<Department> getDepartment(@PathVariable int id) {
        return DataSet.success(departmentService.getDepartment(id));
    }

    @GetMapping("/list")
    public DataSet<List<Department>> getList(Department department) {
        return DataSet.success(departmentService.getList(department));
    }

    @GetMapping("/listByPage")
    public DataSet<List<Department>> getListByPage(Department department, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageUtils.
        return DataSet.success(departmentService.getListByPage(department, pageNum, pageSize));
    }

    @PostMapping
    public DataSet<Department> insertDepartment(@RequestBody Department department) {
        return DataSet.success(departmentService.insertDepartment(department));
    }

    @PutMapping
    public DataSet<Department> updateDepartment(@RequestBody Department department) {
        return DataSet.success(departmentService.updateDepartment(department));
    }

    @DeleteMapping("/{id}")
    public Message deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return Message.success();
    }

}
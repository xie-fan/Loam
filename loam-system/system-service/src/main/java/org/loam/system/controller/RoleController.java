package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Role;
import org.loam.system.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/{id}")
    public DataSet<Role> getRole(@PathVariable Long id) {
        return DataSet.success(roleService.getRole(id));
    }

    @GetMapping("/list")
    public DataSet<List<Role>> getList(Role role) {
        return DataSet.success(roleService.getList(role));
    }

    @GetMapping("/listByPage")
    public DataSet<List<Role>> getListByPage(Role role, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return DataSet.success(roleService.getListByPage(role, pageNum, pageSize));
    }

    @PostMapping
    public DataSet<Role> insertRole(@RequestBody Role role) {
        return DataSet.success(roleService.insertRole(role));
    }

    @PutMapping
    public DataSet<Role> updateRole(@RequestBody Role role) {
        return DataSet.success(roleService.updateRole(role));
    }

    @DeleteMapping("/{id}")
    public Message deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return Message.success();
    }

}

package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "roleRemoteService")
public interface RoleRemoteService {


    @GetMapping("/{id}")
    public DataSet<Role> getRole(@PathVariable int id);

    @GetMapping("/list")
    public DataSet<List<Role>> getList(Role role);

    @GetMapping("/listByPage")
    public DataSet<List<Role>> getListByPage(Role role, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    public DataSet<Role> insertRole(@RequestBody Role role);

    @PutMapping
    public DataSet<Role> updateRole(@RequestBody Role role);

    @DeleteMapping("/{id}")
    public Message deleteRole(@PathVariable int id);

}
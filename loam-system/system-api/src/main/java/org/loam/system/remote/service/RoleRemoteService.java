package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "system-service", path = "/system/role")
public interface RoleRemoteService {


    @GetMapping("/{id}")
    DataSet<Role> getRole(@PathVariable Long id);

    @GetMapping("/list")
    DataSet<List<Role>> getList(@SpringQueryMap Role role);

    @GetMapping("/listByPage")
    DataSet<List<Role>> getListByPage(@SpringQueryMap Role role,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    DataSet<Role> insertRole(@RequestBody Role role);

    @PutMapping
    DataSet<Role> updateRole(@RequestBody Role role);

    @DeleteMapping("/{id}")
    Message deleteRole(@PathVariable Long id);

}

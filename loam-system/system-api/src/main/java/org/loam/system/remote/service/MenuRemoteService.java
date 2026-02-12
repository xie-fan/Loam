package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "system-service", path = "/system/menu")
public interface MenuRemoteService {

    @GetMapping("/{id}")
    DataSet<Menu> getMenu(@PathVariable Long id);

    @GetMapping("/list")
    DataSet<List<Menu>> getList(@SpringQueryMap Menu menu);

    @PostMapping
    DataSet<Menu> insertMenu(@RequestBody Menu menu);

    @PutMapping
    DataSet<Menu> updateMenu(@RequestBody Menu menu);

    @DeleteMapping("/{id}")
    Message deleteMenu(@PathVariable Long id);

}

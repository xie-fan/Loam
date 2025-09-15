package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "menuRemoteService")
public interface MenuRemoteService {

    @GetMapping("/{id}")
    public DataSet<Menu> getMenu(@PathVariable int id);

    @GetMapping("/list")
    public DataSet<List<Menu>> getList(Menu menu);

    @PostMapping
    public DataSet<Menu> insertMenu(@RequestBody Menu menu);

    @PutMapping
    public DataSet<Menu> updateMenu(@RequestBody Menu menu);

    @DeleteMapping("/{id}")
    public Message deleteMenu(@PathVariable int id);

}
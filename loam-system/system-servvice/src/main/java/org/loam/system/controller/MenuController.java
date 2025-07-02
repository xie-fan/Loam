package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Menu;
import org.loam.system.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/{id}")
    public DataSet<Menu> getMenu(@PathVariable int id) {
        return DataSet.success(menuService.getMenu(id));
    }

    @GetMapping("/list")
    public DataSet<List<Menu>> getList(Menu menu) {
        return DataSet.success(menuService.getList(menu));
    }

    @PostMapping
    public DataSet<Menu> insertMenu(@RequestBody Menu menu) {
        return DataSet.success(menuService.insertMenu(menu));
    }

    @PutMapping
    public DataSet<Menu> updateMenu(@RequestBody Menu menu) {
        return DataSet.success(menuService.updateMenu(menu));
    }

    @DeleteMapping("/{id}")
    public Message deleteMenu(@PathVariable int id){
        menuService.deleteMenu(id);
        return Message.success();
    }

}
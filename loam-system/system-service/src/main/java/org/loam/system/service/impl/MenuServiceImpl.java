package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.bean.entity.Menu;
import org.loam.system.mapper.MenuMapper;
import org.loam.system.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public Menu getMenu(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    public List<Menu> getList(Menu menu) {
        return menuMapper.selectList(menu);
    }

    @Override
    public Menu insertMenu(Menu menu) {
        menuMapper.insertMenu(menu);
        return menu;
    }

    @Override
    public Menu updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
        return menu;
    }

    @Override
    public void deleteMenu(Long id) {
        menuMapper.deleteById(id);
    }
}

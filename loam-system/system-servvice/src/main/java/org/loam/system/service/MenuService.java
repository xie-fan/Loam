package org.loam.system.service;

import org.loam.system.bean.entity.Menu;

import java.util.List;

public interface MenuService {
    Menu getMenu(int id);

    List<Menu> getList(Menu menu);

    Menu insertMenu(Menu menu);

    Menu updateMenu(Menu menu);

    void deleteMenu(int id);
}
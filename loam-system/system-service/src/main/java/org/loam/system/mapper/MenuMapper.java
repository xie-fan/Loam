package org.loam.system.mapper;

import org.loam.system.bean.entity.Menu;

import java.util.List;

public interface MenuMapper {

    Menu selectById(Long id);

    List<Menu> selectList(Menu menu);

    void insertMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteById(Long id);
}

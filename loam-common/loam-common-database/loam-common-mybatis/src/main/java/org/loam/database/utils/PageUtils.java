package org.loam.database.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.loam.web.controller.utils.ServletUtils;

public class PageUtils {

    public static void startPage(){
        Integer pageNo = ServletUtils.getIntegerParameter("pageNo", 1);
        Integer pageSize = ServletUtils.getIntegerParameter("pageSize", 20);
        PageHelper.startPage(pageNo, pageSize);
    }
}

package org.loam.test.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {

        ExcelReaderBuilder getAll = EasyExcel.read("C:\\Users\\xiefan\\Desktop\\test2.xlsx", new ReadListener<Map<String, String>>() {

            @Override
            public void invoke(Map<String, String> data, AnalysisContext context) {
                System.out.println(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("get all");
            }
        });
        getAll.sheet().doRead();

        ExcelReaderBuilder read = EasyExcel.read("C:\\Users\\xiefan\\Desktop\\test2.xlsx");
        ExcelReaderSheetBuilder sheet = read.sheet();
        List<Object> objects = sheet.doReadSync();
        System.out.println("end");
    }
}

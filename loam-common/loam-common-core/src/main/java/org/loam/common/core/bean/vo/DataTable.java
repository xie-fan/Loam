package org.loam.common.core.bean.vo;

import org.loam.common.core.constant.HttpConstant;
import org.loam.common.core.enums.HttpStatus;

import java.util.List;

public class DataTable<T extends List<?>> extends DataSet<T>{
    
    private Long total;

    protected DataTable(T data, Long total, String message, int code) {
        super(data, message, code);
        this.total = total;
    }

    protected DataTable(T data, Integer total, String message, int code) {
        super(data, message, code);
        this.total = Long.valueOf(total);
    }

    public static <T extends List<?>> DataTable<T> success(T data){
        return new DataTable<>(data, data.size(), HttpConstant.SUCCESS, HttpStatus.SUCCESS.code);
    }

    public static <T extends List<?>> DataTable<T> success(T data, Long total){
        return new DataTable<>(data, total, HttpConstant.SUCCESS, HttpStatus.SUCCESS.code);
    }

    public static <T extends List<?>> DataTable<T> success(T data, Long total, String message){
        return new DataTable<>(data, total, message, HttpStatus.SUCCESS.code);
    }

    public static <T extends List<?>> DataTable<T> success(T data, Long total, String message, int code){
        return new DataTable<>(data, total, message, code);
    }

    public static DataTable<?> error(){
        return new DataTable<>(null, 0, HttpConstant.ERROR, HttpStatus.FAILURE.code);
    }

    public static DataTable<?> error(String message){
        return new DataTable<>(null, 0, message, HttpStatus.FAILURE.code);
    }

    public static DataTable<?> error(String message, int code){
        return new DataTable<>(null, 0, message, code);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

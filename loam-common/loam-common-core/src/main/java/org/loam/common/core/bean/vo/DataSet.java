package org.loam.common.core.bean.vo;

import org.apache.commons.lang3.ObjectUtils;
import org.loam.common.core.constant.HttpConstant;
import org.loam.common.core.enums.HttpStatus;

import java.util.Optional;

public class DataSet<T> extends Message{
    protected T data;

    protected DataSet(T data, String message, int code) {
        super(message, code);
        this.data = data;
    }

    public static <T> DataSet<T> success(T data){
        return new DataSet<>(data, HttpConstant.SUCCESS, HttpStatus.SUCCESS.code);
    }

    public static <T> DataSet<T> success(T data, String message){
        return new DataSet<>(data, message, HttpStatus.SUCCESS.code);
    }

    public static <T> DataSet<T> success(T data, String message, int code){
        return new DataSet<>(data, message, code);
    }

    public static <T> DataSet<T> error(T data){
        return new DataSet<>(data, HttpConstant.ERROR, HttpStatus.FAILURE.code);
    }

    public static <T> DataSet<T> error(T data, String message){
        return new DataSet<>(data, message, HttpStatus.FAILURE.code);
    }

    public static <T> DataSet<T> error(T data, String message, int code){
        return new DataSet<>(data, message, code);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isEmpty(){
        return ObjectUtils.isEmpty(data);
    }

    public boolean isPresent(){
        return ObjectUtils.isNotEmpty(data);
    }
}

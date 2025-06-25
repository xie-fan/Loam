package org.loam.common.core.bean.vo;

import org.loam.common.core.constant.HttpConstant;
import org.loam.common.core.enums.HttpStatus;

public class Message {

    protected String message;

    protected int code;

    protected Message(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public static Message success(){
        return new Message(HttpConstant.SUCCESS, HttpStatus.SUCCESS.code);
    }

    public static Message success(String message){
        return new Message(message, HttpStatus.SUCCESS.code);
    }

    public static Message success(String message, int code){
        return new Message(message, code);
    }

    public static Message error(){
        return new Message(HttpConstant.ERROR, HttpStatus.FAILURE.code);
    }

    public static Message error(String message){
        return new Message(message, HttpStatus.FAILURE.code);
    }

    public static Message error(String message, int code){
        return new Message(message, code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

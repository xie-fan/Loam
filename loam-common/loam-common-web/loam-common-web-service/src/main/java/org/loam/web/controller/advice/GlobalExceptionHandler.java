package org.loam.web.controller.advice;

import jakarta.validation.ConstraintViolationException;
import org.loam.common.core.bean.vo.Message;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            ConstraintViolationException.class,
            HttpMessageNotReadableException.class,
            IllegalArgumentException.class,
            IllegalStateException.class
    })
    public Message handleBadRequest(Exception e) {
        return Message.error(e.getMessage(), 400);
    }

    @ExceptionHandler(Exception.class)
    public Message handleException(Exception e) {
        return Message.error(e.getMessage());
    }
}

package org.loam.common.core.enums;

public enum HttpStatus {

    SUCCESS(200),
    FAILURE(500)
    ;
    public final Integer code;

    HttpStatus(Integer code) {
        this.code = code;
    }
}

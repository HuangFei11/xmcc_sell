package com.xmcc.wx_sell.exception;

import com.xmcc.wx_sell.common.ResultEnums;

public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        this(ResultEnums.FAIL.getCode(), message);
    }

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }
}

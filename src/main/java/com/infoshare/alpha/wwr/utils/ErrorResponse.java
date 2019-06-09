package com.infoshare.alpha.wwr.utils;

public class ErrorResponse {

    private String message;

    private int code;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "{" + "message:'" + message + '\'' + ", code:" + code + '}';
    }
}

package com.dinner3000.springmvc.exception;

public class AjaxException extends Exception{

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;

    public AjaxException(int code) {
        this.code = code;
    }

    public AjaxException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AjaxException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}

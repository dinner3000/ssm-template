package com.dinner3000.springmvc.model;

public class AjaxResponse {
    private int code = 200;
    private String desc = "OK";
    private Object data = null;

    public AjaxResponse(){
    }

    public AjaxResponse(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public AjaxResponse(int code, String desc, Object data){
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public AjaxResponse(Object data){
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

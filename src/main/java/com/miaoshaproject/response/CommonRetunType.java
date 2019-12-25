package com.miaoshaproject.response;

public class CommonRetunType {
    private String status;
    private Object data;

    public static CommonRetunType create(Object result) {
        return CommonRetunType.create("success", result);
    }

    public static CommonRetunType create(String status, Object result) {
        CommonRetunType type = new CommonRetunType();
        type.status = status;
        type.data = result;
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

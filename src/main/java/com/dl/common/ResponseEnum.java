package com.dl.common;

/**
 * @author Li Lun
 * @date 2018/9/26 10:27
 * @description 响应结果
 */

public enum ResponseEnum {

    SUCCESS(0, "Success"), FAILURE(1000, "Failure");

    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format("{\"code\": %d, \"msg\": \"%s\"}", this.code, this.msg);
    }
}

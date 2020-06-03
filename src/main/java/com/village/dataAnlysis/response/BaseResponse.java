package com.village.dataAnlysis.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    /**
     * 是否成功
     */
    private boolean success =true;

    /**
     * 说明
     */
    private String msg = "请求成功";

    private Integer code = 200;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

}

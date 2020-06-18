package com.village.dataAnlysis.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("api统一返回格式")
public class BaseResponse<T> {

    /**
     * 是否成功
     */
    @ApiModelProperty("请求是否成功")
    private boolean success =true;

    /**
     * 说明
     */
    @ApiModelProperty("请求返回描述")
    private String msg = "请求成功";

    @ApiModelProperty("请求返回码")
    private Integer code = 200;

    /**
     * 返回数据
     */
    @ApiModelProperty("请求返回数据")
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

}

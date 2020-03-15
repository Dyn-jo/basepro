package com.dyn.basepro.frame.response;

import lombok.Getter;

/**
 *@description: 通用返回类型
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
@Getter
public class CommonResult<T> {

    private String code;

    private String message;

    private T data;

    private CommonResult(T data) {
        this.code = "0000";
        this.message = "成功";
        this.data = data;
    }

    private CommonResult(CodeMessage cm, T data) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.message = cm.getMessage();
        this.data = data;
    }

    /**
     * 成功时候的调用
     *
     * @return
     */
    public static <T> CommonResult<T> build(T data) {
        return new CommonResult<T>(data);
    }

    /**
     * 失败时候的调用,有响应内容
     *
     * @param cm
     * @param data
     * @return
     */
    public static <T> CommonResult<T> build(CodeMessage cm, T data) {
        return new CommonResult<T>(cm, data);
    }

}

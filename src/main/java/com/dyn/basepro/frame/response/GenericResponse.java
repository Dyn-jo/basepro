package com.dyn.basepro.frame.response;

import lombok.Getter;

@Getter
public class GenericResponse<T> {

    private String code;

    private String message;

    private T data;

    private GenericResponse(T data) {
        this.code = "0000";
        this.message = "成功";
        this.data = data;
    }

    private GenericResponse(com.dyn.basepro.response.CodeMessage cm, T data) {
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
    public static <T> GenericResponse<T> build(T data) {
        return new GenericResponse<T>(data);
    }

    /**
     * 失败时候的调用,有响应内容
     *
     * @param cm
     * @param data
     * @return
     */
    public static <T> GenericResponse<T> build(com.dyn.basepro.response.CodeMessage cm, T data) {
        return new GenericResponse<T>(cm, data);
    }

}

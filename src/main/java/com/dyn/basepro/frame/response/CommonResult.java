package com.dyn.basepro.frame.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    private CommonResult(CodeMessage cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.message = cm.getMessage();
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

    /***
     *@Description: 失败时候的调用,无响应内容
     *@Param: [cm]
     *@return: com.dyn.basepro.frame.response.CommonResult<T>
     *@Author: dyn
     *@date: 2020/3/22 0022 下午 7:06
     */
    public static <T> CommonResult<T> build(CodeMessage cm) {
        return new CommonResult<T>(cm);
    }

    /**
     * 将分页后的IPage转为分页信息
     */
    public static <T> CommonResult<T> buildPage(IPage iPage) {

        CommonPage<T> result = new CommonPage<T>();
        result.setCurrent(iPage.getCurrent());
        result.setPages(iPage.getPages());
        result.setRecords(iPage.getRecords());
        result.setSize(iPage.getSize());
        result.setTotal(iPage.getTotal());
        return (CommonResult<T>) CommonResult.build(result);
    }

}

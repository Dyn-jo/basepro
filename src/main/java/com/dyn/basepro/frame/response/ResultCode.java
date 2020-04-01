package com.dyn.basepro.frame.response;

/**
 *@description: 通用异常码
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
public interface ResultCode {

    // 通用异常
    CodeMessage SUCCESS = CodeMessage.of("0000", "成功");

    CodeMessage SYSTEM_ERROR = CodeMessage.of("9999", "系统异常！");

    // 登录鉴权
    CodeMessage VALIDATE_FAILED = CodeMessage.of("1001", "参数检验失败！");

    CodeMessage UNAUTHORIZED = CodeMessage.of("1002", "暂未登录或token已经过期！");

    CodeMessage FORBIDDEN = CodeMessage.of("1003", "没有相关权限！");

    CodeMessage LOGIN_FAILED = CodeMessage.of("1004", "用户名或密码错误！");



    // db相关
    CodeMessage SELECT_FAILED = CodeMessage.of("2001", "查询失败！");

    CodeMessage SAVE_FAILED = CodeMessage.of("2002", "保存失败！");

    CodeMessage UPDATE_FAILED = CodeMessage.of("2003", "更新失败！");

    CodeMessage DELETE_FAILED = CodeMessage.of("2004", "删除失败！");

}

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

}

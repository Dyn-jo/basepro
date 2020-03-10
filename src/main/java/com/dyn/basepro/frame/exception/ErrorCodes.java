package com.dyn.basepro.frame.exception;

import com.dyn.basepro.response.CodeMessage;

public interface ErrorCodes {

    // 通用异常
    CodeMessage SUCCESS = CodeMessage.of("0000", "成功");

    CodeMessage SYSTEM_ERROR = CodeMessage.of("9999", "系统异常！");

}

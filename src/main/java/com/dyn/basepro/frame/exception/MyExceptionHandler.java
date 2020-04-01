package com.dyn.basepro.frame.exception;

import com.dyn.basepro.frame.response.CodeMessage;
import com.dyn.basepro.frame.response.CommonResult;
import com.dyn.basepro.frame.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@description: 异常处理
 *@author: dyn
 *@create: 2020-03-10 21:11
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResult handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);

        return CommonResult.build(CodeMessage.of(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult Exception(Exception e) {

        log.error(e.getMessage(), e);
        return CommonResult.build(ResultCode.SYSTEM_ERROR);
    }

}

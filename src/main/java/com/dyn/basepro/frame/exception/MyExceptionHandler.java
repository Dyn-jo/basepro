package com.dyn.basepro.frame.exception;

import com.dyn.basepro.response.CodeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public CodeMessage handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return CodeMessage.of(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CodeMessage Exception(Exception e) {

        log.error(e.getMessage(), e);
        return ErrorCodes.SYSTEM_ERROR;
    }

}

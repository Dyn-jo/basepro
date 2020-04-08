package com.dyn.basepro.frame.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *@description: 请求log打印
 *@author: dyn
 *@create: 2020-04-08 21:05
 */
@Aspect
@Configuration
@Slf4j
public class RequestInfoLogAspect {

    @Pointcut("execution(* com.dyn.*.*.controller.*Controller.*(..))")
    public void excudeService() {}

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String paramString = null;
        try {
            paramString = JSONUtil.toJsonPrettyStr(pjp.getArgs());
        } catch (Exception e) {
        }
        String jpclass = pjp.getTarget().getClass().toString();
        String jpmethod = pjp.getSignature().getName();
        log.info("Controller接收请求，URI:{},method:{},params:{},处理类为:{},处理方法为:{}", uri, method, paramString, jpclass, jpmethod);
        Object result = pjp.proceed();
        log.info("Controller接收结束，Controller:{}方法{}的返回值是:{}", jpclass, jpmethod, JSONUtil.toJsonPrettyStr(result));
        return result;
    }

}

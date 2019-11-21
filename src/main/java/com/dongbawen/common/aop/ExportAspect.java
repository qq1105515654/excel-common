package com.dongbawen.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author snh
 * @version 1.0
 * @className ExportAspect
 * @description TODO
 * @date 2019/11/11 17:25
 **/
@Aspect
//@Component
@Slf4j
public class ExportAspect {

    @Pointcut("@annotation(com.dongbawen.common.annotation.ExcelExport)")
    public void handlerExportPointcut(){};


    @Around("handlerExportPointcut()")
    public void handlerExportAnnotation(ProceedingJoinPoint joinPoint){


    }

}

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
 * @className AnnotationAspect
 * @description TODO
 * @date 2019/11/11 16:54
 **/
@Aspect
//@Component
@Slf4j
public class ImportAspect {

    @Pointcut("@annotation(com.dongbawen.common.annotation.ExcelImport)")
    public void handleImportPointcut(){};

    @Around("handleImportPointcut()")
    public void handlerImportAnnotation(ProceedingJoinPoint joinPoint){
        Class pointClass=joinPoint.getTarget().getClass();


    }
}

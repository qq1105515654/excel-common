package com.dongbawen.common.handler.annotation;

import java.lang.annotation.Annotation;

/**
 * @author snh
 * @version 1.0
 * @className AnnotationHandler
 * @description TODO 注解处理接口
 * @date 2019/11/11 10:45
 **/
public interface AnnotationHandler<T,A extends Annotation> {

    /**
     * 获取注解
     * @param t
     * @param a
     * @return
     */
    default A getAnnotation(T t,Class<A> a){
        Class originClass=t.getClass();
        if(originClass.isAnnotationPresent(a)) {
            A annotation = (A) originClass.getAnnotation(a);
            return annotation;
        }
        return null;
    };



}

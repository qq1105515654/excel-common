package com.dongbawen.common.handler.annotation.process;

import com.dongbawen.common.annotation.ExcelIgnore;
import com.dongbawen.common.handler.annotation.AbstractAnnotationHandler;
import com.dongbawen.common.utils.ObjectUtils;

import java.lang.reflect.Field;

/**
 * @author snh
 * @version 1.0
 * @className ExcelIgnoreAnnotationHandlerProcess
 * @description TODO
 * @date 2019/11/11 16:42
 **/
public class ExcelIgnoreAnnotationHandlerProcess<T,A> extends AbstractAnnotationHandler<T, ExcelIgnore> {

    private ExcelIgnore ignore;


    @Override
    public ExcelIgnore getAnnotation(T t, Class<ExcelIgnore> a) {
        Field field= (Field) t;
        this.ignore=field.getAnnotation(a);
        return this.ignore;
    }

    public boolean isIgnore(){
        if(ObjectUtils.nonNull(ignore)){
            return true;
        }
        return false;
    }
}

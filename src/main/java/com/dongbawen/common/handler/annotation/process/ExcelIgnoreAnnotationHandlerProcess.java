package com.dongbawen.common.handler.annotation.process;

import com.dongbawen.common.annotation.ExcelIgnore;
import com.dongbawen.common.handler.annotation.AbstractAnnotationHandler;
import com.dongbawen.common.utils.ObjectUtils;

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
        this.ignore=super.getAnnotation(t,a);
        return this.ignore;
    }

    public boolean isIgnore(){
        if(ObjectUtils.nonNull(ignore)){
            return true;
        }
        return false;
    }
}

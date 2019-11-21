package com.dongbawen.common.handler.annotation.process;

import com.dongbawen.common.annotation.ExcelTarget;
import com.dongbawen.common.handler.annotation.AbstractAnnotationHandler;

import java.lang.annotation.Annotation;

/**
 * @author snh
 * @version 1.0
 * @className ExcelTypeAnnotationHandlerProcess
 * @description TODO 类
 * @date 2019/11/11 15:10
 **/
public class ExcelTypeAnnotationHandlerProcess<T,A extends Annotation> extends AbstractAnnotationHandler<T, ExcelTarget> {

    private ExcelTarget target;


    public String getSheetName(){
        return target.sheetName();
    }

    @Override
    public ExcelTarget getAnnotation(T t, Class<ExcelTarget> a) {
        this.target=super.getAnnotation(t, a);
        return target;
    }
}

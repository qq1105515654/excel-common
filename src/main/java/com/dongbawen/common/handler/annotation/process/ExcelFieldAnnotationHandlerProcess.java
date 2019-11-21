package com.dongbawen.common.handler.annotation.process;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.handler.annotation.AbstractAnnotationHandler;

import java.lang.annotation.Annotation;

/**
 * @author snh
 * @version 1.0
 * @className ExcelFieldAnnotationHandlerProcess
 * @description TODO
 * @date 2019/11/11 14:00
 **/
public class ExcelFieldAnnotationHandlerProcess<T,A extends Annotation> extends AbstractAnnotationHandler<T,Excel> {

    private Excel excelAnnotation;


    @Override
    public Excel getAnnotation(T t, Class<Excel> a) {
        Excel annotation=super.getAnnotation(t,a);
        this.excelAnnotation=annotation;
        return annotation;
    }

    public String getName(){
        return excelAnnotation.name();
    }

    public int getIndex(){
        return excelAnnotation.index();
    }

    public String getDateFormat(){
        return excelAnnotation.dateFormat();
    }

    public String getMaxLength(){
        return excelAnnotation.maxLength();
    }

    public String getMinLength(){
        return excelAnnotation.minLength();
    }

    public String[] getReplace(){
        return excelAnnotation.replace();
    }

    public boolean isRequired(){
        return excelAnnotation.isRequired();
    }

    public boolean isSharedField(){
        return excelAnnotation.isSharedField();
    }

}

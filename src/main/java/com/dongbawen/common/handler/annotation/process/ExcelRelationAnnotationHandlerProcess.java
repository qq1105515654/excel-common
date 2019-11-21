package com.dongbawen.common.handler.annotation.process;

import com.dongbawen.common.annotation.ExcelCollections;
import com.dongbawen.common.handler.annotation.AbstractAnnotationHandler;
import com.dongbawen.common.utils.ObjectUtils;

/**
 * @author snh
 * @version 1.0
 * @className ExcelRelationAnnotationHandlerProcess
 * @description TODO
 * @date 2019/11/11 16:00
 **/
public class ExcelRelationAnnotationHandlerProcess<T,A> extends AbstractAnnotationHandler<T, ExcelCollections> {

    private ExcelCollections collections;

    @Override
    public ExcelCollections getAnnotation(T t, Class<ExcelCollections> a) {
        this.collections=super.getAnnotation(t,a);
        return this.collections;
    }


    public boolean isRelation(){
        if(ObjectUtils.nonNull(collections)){
            return true;
        }
        return false;
    }

}

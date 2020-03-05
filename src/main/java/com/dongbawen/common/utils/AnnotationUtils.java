package com.dongbawen.common.utils;

import com.dongbawen.common.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className AnnotationUtils
 * @description TODO 注解工具类
 * @date 2019/11/11 14:17
 **/
public class AnnotationUtils {

    /**
     * 根据属性名获取指定注解的属性值
     * @param annotation 注解
     * @param property  属性名
     * @return
     */
    public static Object getAnnotationValue(Annotation annotation,String property){
        Object result=null;
        if(annotation!=null){
            InvocationHandler handler= Proxy.getInvocationHandler(annotation);
            Map map= (Map) getFieldValue(handler,"memberValues");
            if(map!=null){
                result=map.get(property);
            }
        }
        return result;
    }

    /**
     *  内部方法，获取注解的属性映射集合
     * @param object
     * @param property
     * @param <T>
     * @return
     */
    private static <T> Object getFieldValue(T object,String property){
        if(ObjectUtils.nonNull(object) && ObjectUtils.nonNull(property)){
            Class<T> currClass= (Class<T>) object.getClass();
            try {
                Field field=currClass.getDeclaredField(property);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 匹配 Excel 注解
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> boolean matchExcelAnnotation(Class<T> obj){
        return matchAnnotation(obj,Excel.class);
    }

    /**
     * 匹配 ExcelCollections 注解
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> boolean matchExcelCollections(Class<T> obj){
        return matchAnnotation(obj, ExcelCollections.class);
    }

    /**
     * 匹配 ExcelIgnore 注解
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> boolean matchExcelIgnore(Class<T> obj){
        return matchAnnotation(obj, ExcelIgnore.class);
    }

    /**
     * 匹配 ExcelTarget 注解
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> boolean matchExcelTarget(Class<T> obj){
        return matchAnnotation(obj, ExcelTarget.class);
    }

    /**
     * 匹配对象中的注解
     * @param obj   源对象
     * @param annotationClass 注解反射
     * @param <T>
     * @return
     */
    public static <T> boolean matchAnnotation(Class<T> obj,Class annotationClass){
        if(ObjectUtils.isNull(obj) || ObjectUtils.isNull(annotationClass)){
            return false;
        }
        if(obj.isAnnotationPresent(annotationClass)){
            return true;
        }
        return false;
    }

    /**
     * 判断该字段是否为必须要填写的
     * @param field
     * @param property
     * @return
     */
    public static boolean isRequired(Field field,String property){
        Annotation annotation=field.getAnnotation(Excel.class);
        return (boolean) getAnnotationValue(annotation,"isRequired");
    }


   /* public static void main(String[] args) {
        *//*Student student=new Student();
        Class clz=student.getClass();
        Annotation annotation=clz.getAnnotation(ExcelTarget.class);
        System.out.println(getAnnotationValue(annotation,"sheetName"));*//*
    }*/
}

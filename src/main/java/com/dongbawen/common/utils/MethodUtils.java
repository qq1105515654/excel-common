package com.dongbawen.common.utils;

import com.dongbawen.common.entity.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author snh
 * @version 1.0
 * @className MethodUtils
 * @description TODO 方法工具类
 * @date 2019/11/13 14:22
 **/
public class MethodUtils {

    /**
     * 调用对象属性的GET方法获取值
     * @param obj
     * @param fieldName
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static Object invokeGet(Object obj,String fieldName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method=obj.getClass().getMethod(byFieldToGetMethod(fieldName));
        return method.invoke(obj);
    }

    /**
     * 调用对象属性的SET方法，设置值
     * @param obj   对象
     * @param fieldName 属性名
     * @param values    值的可增长参数
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void invokeSet(Object obj,String fieldName,Object ... values) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] paramType=new Class[values.length];
        for (int i = 0; i < values.length; i++) {
            paramType[i]=values[i].getClass();
        }
        Method method=obj.getClass().getMethod(byFieldToSetMethod(fieldName),paramType);
        method.invoke(obj,values);
    }

    public static String byFieldToSetMethod(String fieldName){
        return "set"+firstUpperCase(fieldName);
    }

    public static String byFieldToGetMethod(String fieldName){
        return "get"+firstUpperCase(fieldName);
    }

    private static String firstUpperCase(String fieldName){
        char[] chars=fieldName.toCharArray();
        if(chars[0] >= 'a' || chars[0] <= 'z'){
            chars[0]= (char) (chars[0]-32);
        }
        return new String(chars);
    }
}

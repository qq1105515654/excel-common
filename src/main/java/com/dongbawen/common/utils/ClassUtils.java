package com.dongbawen.common.utils;

import com.dongbawen.common.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className ClassUtils
 * @description TODO 用于解析Excel实体类反射对象的工具类
 * @date 2019/11/11 9:04
 **/
public class ClassUtils {

    /**
     *  根据原始对象，属性名设置属性的值
     * @param originObj 源对象
     * @param fieldName 属性名
     * @param value     值
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void setFieldsValue(Object originObj,String fieldName,Object value){
        try {
           MethodUtils.invokeSet(originObj,fieldName,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据对象的反射获取该对象的所有属性名
     * @param originClass
     * @return
     */
    public static List<String> getFieldsName(Class originClass){
        List<String> fieldList=new ArrayList<>();
        Field[] fields=originClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fieldList.add(fields[i].getName());
        }
        return fieldList;
    }

    /**
     * 获取源对象的所有属性对象
     * @param originClass
     * @return
     */
    public static List<Field> getFields(Class originClass){
        Field[] fields=originClass.getDeclaredFields();
        return new ArrayList<>(Arrays.asList(fields));
    }

    /**
     *  根据源对象，还有属性名，获取该属性的值。
     * @param originObj 原始对象
     * @param fieldName 属性名
     * @return 返回该属性的值
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object originObj,String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class originClass=originObj.getClass();
        String methodName=MethodUtils.byFieldToGetMethod(fieldName);
        Method method=originClass.getMethod(methodName);
        return method.invoke(originObj);
    }

    /**
     * 将一行数据解析为实体类
     * @param clz   实体类反射
     * @param map    去除忽略跟集合一对一，一对多关系之后的属性集合
     * @param row  一行数据
     * @param <T>
     * @return
     */
    public static <T>Object parseToEntity(Class<T> clz, Map<Integer,Field> map, Row row) throws IllegalAccessException, InstantiationException {
        T t=clz.newInstance();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Field field=map.get(i);
            Cell cell=row.getCell(i);
            String value=cell.getStringCellValue();
            if(DataValidationUtils.checkFieldIsRequired(field) && StringUtils.isNotEmpty(value)){
                field.setAccessible(true);
                field.set(t,value);
            }
        }
        return t;
    }

    public static void main(String[] args){
       Student student=new Student();
       setFieldsValue(student,"name","成吉思汗");
       System.out.println(student.getName());
    }
}

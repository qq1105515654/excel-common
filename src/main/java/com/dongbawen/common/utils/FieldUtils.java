package com.dongbawen.common.utils;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelCollections;
import com.dongbawen.common.annotation.ExcelEntity;
import com.dongbawen.common.annotation.ExcelIgnore;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className FieldUtils
 * @description TODO 属性工具类
 * @date 2019/11/13 15:05
 **/
public class FieldUtils {

    /**
     * 获取删除掉一对多集合的属性和忽略的属性之后的属性集合
     * @param clazz
     * @return
     */
    public static List<Field> getEndField(Class clazz){
        List<Field> fields=ClassUtils.getFields(clazz);
        removeIgnoreField(fields);
        return fields;
    }

    /**
     * 获取对象中存在一对多的所有集合，属性
     * @param fields
     * @return
     */
    public static List<Field> getCollectionField(List<Field> fields){
        List<Field> collection=new ArrayList<>();
        fields.forEach(field -> {
            if(field.isAnnotationPresent(ExcelCollections.class)){
                collection.add(field);
            }
        });
        return collection;
    }

    public static List<Field> removeIgnoreField(List<Field> fields){
        Iterator<Field> iterator=fields.iterator();
        while(iterator.hasNext()){
            Field field=iterator.next();
            if(field.isAnnotationPresent(ExcelEntity.class)
                    ||field.isAnnotationPresent(ExcelCollections.class)
                    ||field.isAnnotationPresent(ExcelIgnore.class)
                    ||field.getAnnotation(Excel.class)==null){
                iterator.remove();
            }
        }
        return fields;
    }

    /**
     * 使用单元格标题匹配实体类中的属性上的注解的name值
     * @param fields 实体类属性列表
     * @param title 列标题
     * @param index 列标题的索引
     * @return
     */
    public static Field matchField(List<Field> fields,String title,int index){
        for (Field field : fields) {
            if(!field.isAnnotationPresent(Excel.class)){
                return null;
            }
            Annotation annotation=field.getAnnotation(Excel.class);
            String fieldTitle= (String) AnnotationUtils.getAnnotationValue(annotation,"name");
            int fieldIndex= (int) AnnotationUtils.getAnnotationValue(annotation,"index");
            if(StringUtils.isNotEmpty(fieldTitle) && fieldTitle.equals(title.trim()) && fieldIndex==index){
                return field;
            }
        }
        return null;
    }
}

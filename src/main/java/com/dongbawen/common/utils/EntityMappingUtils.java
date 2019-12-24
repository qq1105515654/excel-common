package com.dongbawen.common.utils;

import com.dongbawen.common.annotation.ExcelTarget;

import java.util.HashMap;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className EntityMappingUtils
 * @description TODO
 * @date 2019/12/23 15:57
 **/
public class EntityMappingUtils {

    public static Map<String,Class> excelClassMap=new HashMap<>();


    /**
     * 获取实体类的{"sheetName":class} 映射
     * @param targetClasses
     * @return
     */
    public static Map<String,Class> getMapping(Class ... targetClasses){
        for (Class targetClass : targetClasses) {
            if(targetClass.isAnnotationPresent(ExcelTarget.class)){
                ExcelTarget target= (ExcelTarget) targetClass.getAnnotation(ExcelTarget.class);
                excelClassMap.put(target.sheetName(),targetClass);
            }
        }
        return excelClassMap;
    }

}

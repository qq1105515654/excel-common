package com.dongbawen.common.utils;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelTarget;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className DataValidationUtils
 * @description TODO
 * @date 2019/11/13 15:01
 **/
@Slf4j
public class DataValidationUtils {


    /**
     * 校验该Excel表格格式是否跟实体类的格式一致,并且检验必填项是否填写
     * @param sheet
     * @param clazz
     * @return
     */
    public static boolean checkFormat(Sheet sheet,Class clazz){
        log.info("The start sheet check with title format.");
        List<Field> fields=FieldUtils.getEndField(clazz);
        //获取标题行
        Row titleRow=sheet.getRow(0);
        if(fields.size()!=titleRow.getLastCellNum()){
            log.info("The column count with entity field count not match.");
            return false;
        }
        for (int i = 0; i < titleRow.getLastCellNum(); i++) {
            Cell cell=titleRow.getCell(i);
            String cellTitle=cell.getStringCellValue();
            log.info("Current use：{} ,compare to entity field the annotation name field.",cellTitle);
            Field field=FieldUtils.matchField(fields,cellTitle,i);
            if(field==null){
                log.info("Compare to result：failed.");
                return false;
            }
        }
        log.info("Compare to result：success");
        return true;
    }

    /**
     * 校验该表格的 sheet 名字跟我们实体类上的 ExcelTarget注解的 sheetName名字是否匹配
     * @param sheet
     * @param clz
     * @return
     */
    public static boolean checkSheetName(Sheet sheet,Class clz){
        String sheetName=sheet.getSheetName();
        String entitySheetName= (String) getEntitySheetName(clz);
        if(StringUtils.isNotEmpty(sheetName) && sheetName.equals(entitySheetName)){
            return true;
        }
        return false;
    }

    /**
     * 获取实体类上的 ExcelTarget 注解的 sheetName值
     * @param clz
     * @return
     */
    public static Object getEntitySheetName(Class clz){
        Annotation annotation=clz.getAnnotation(ExcelTarget.class);
        return AnnotationUtils.getAnnotationValue(annotation,"sheetName");
    }

    /**
     * 检查字段是否为必填项
     * @param field
     * @return
     */
    public static boolean checkFieldIsRequired(Field field){
        if(!field.isAnnotationPresent(Excel.class)){
            return false;
        }
        Annotation annotation=field.getAnnotation(Excel.class);
        return (boolean) AnnotationUtils.getAnnotationValue(annotation,"isRequired");
    }

}

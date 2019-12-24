package com.dongbawen.common.handler.imported.process;

import com.alibaba.fastjson.JSONArray;
import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.dto.ExcelImportErrorDto;
import com.dongbawen.common.handler.annotation.process.ExcelFieldAnnotationHandlerProcess;
import com.dongbawen.common.handler.imported.AbstractImportHandler;
import com.dongbawen.common.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author snh
 * @version 1.0
 * @className ImportHandlerProcess
 * @description TODO
 * @date 2019/11/11 17:42
 **/
@Slf4j
@Component
public class ImportHandlerProcess extends AbstractImportHandler {

    @Autowired
    private ExcelUtils excelUtils;

    private List<ExcelImportErrorDto> responseDto=new ArrayList<>();

    @Override
    public Map<String, List> importDataHandler(MultipartFile file, Class... excelTargetClass) {
        Map<String,List> result=new HashMap<>(0);
        Workbook workbook=checkFileType(file);
        Map<String,Class> map=EntityMappingUtils.getMapping(excelTargetClass);
        Map<String, JSONArray> jsonArrayMap=excelUtils.excelToMap(workbook);
        for (String key : jsonArrayMap.keySet()) {
            JSONArray jsonArray=jsonArrayMap.get(key);
            Class entityClass=map.get(key);
            if(entityClass==null){
                continue;
            }
            try {
                result.put(key,excelUtils.jsonArrayToList(entityClass,jsonArray));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public Workbook checkFileType(MultipartFile multipartFile) {
        return ExcelUtils.checkVersion(multipartFile);
    }


    private List<T> excelDataConvertObj(Class<T> c, Sheet sheet){

        //判断该反射的注解标记是否为实体类
        if(AnnotationUtils.matchExcelTarget(c)){
            //处理实体类的逻辑

        }else if(AnnotationUtils.matchExcelCollections(c)){
            //处理一对多关系映射逻辑

        }else if(AnnotationUtils.matchExcelIgnore(c)){
            //忽略字段处理

        }
        return null;
    }


    /**
     * 创建列标题
     * @param titleMap 标题键值对 {index:"title"}
     * @param sheet
     */
    private void createSheetColumnTitle(Map<Integer,String> titleMap,Sheet sheet){
        if(ObjectUtils.isNull(titleMap) || ObjectUtils.isNull(sheet)){
            return;
        }
        if(sheet.getLastRowNum()>0){
            return;
        }
        //标题行位于表格的第一行
        Row titleRow=sheet.createRow(0);
        Set<Integer> indexSet=titleMap.keySet();
        //根据字段索引来确定标题的位置
        for (Integer index : indexSet) {
            Cell cell=titleRow.createCell(index);
            cell.setCellValue(titleMap.get(index));
        }
    }

    /**
     * 获取sheet 标题跟索引
     * @param sheet
     * @return 标题键值对 {index:"title"}
     */
    private Map<Integer,String> getSheetColumnTitle(Sheet sheet){
        Map<Integer,String> map=new HashMap<>(0);
        if(ObjectUtils.isNull(sheet)){
            return null;
        }
        if(sheet.getLastRowNum()>0){
            return null;
        }
        //标题行位于表格的第一行
        Row titleRow=sheet.getRow(0);
        for (int i = 0; i < titleRow.getLastCellNum(); i++) {
            map.put(i,titleRow.getCell(i).getStringCellValue());
        }
        return map;
    }

    /**
     * 获取属性下标跟对应数据的key_value{index:Field}
     * @param fields
     * @return
     */
    private Map<Integer,Field> getFieldIndex(List<Field> fields){
        Map<Integer,Field> map=new HashMap<>(5);
        fields.forEach(field -> {
            Excel excel=new ExcelFieldAnnotationHandlerProcess<>().getAnnotation(field,Excel.class);
            map.put(excel.index(),field);
        });
        return map;
    }

    /**
     *  根据 sheet name 去匹配 ExcelTarget 的 name 如果匹配上 则取该类的属性去取 Excel的单元格信息
     * @param sheet
     * @param clazz
     */
    public List<T> sheetConvertEntity(Sheet sheet,Class<T> clazz) throws IllegalAccessException, InstantiationException {
        List<T> list=new ArrayList<>();
        //判断sheet Name 跟 表格格式是否跟实体类属性是否一致
        if(!DataValidationUtils.checkSheetName(sheet,clazz) || DataValidationUtils.checkFormat(sheet,clazz)){
            return null;
        }
        //获取标题集合跟索引的映射
        Map<Integer,String> titleMap=getSheetColumnTitle(sheet);
        if(ObjectUtils.isNull(titleMap) || titleMap.size()==0){
            log.info("Not get to the title collection.");
            return null;
        }
        log.info("Start convert excel data.");
        //将一对多,还有带有忽略标记的字段删除之后的属性集合
        List<Field> fields=FieldUtils.getEndField(clazz);
        Map<Integer,Field> fieldMap=getFieldIndex(fields);
        //由于第一行是标题信息，所以这里从第二行开始拿数据
        for(int r=1; r <= sheet.getLastRowNum(); r++){
            Row row=sheet.getRow(r);

        }

        return null;
    }

}

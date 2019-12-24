package com.dongbawen.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongbawen.common.annotation.Excel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className ExcelUtils
 * @description TODO Excel工具类
 * @date 2019/11/20 9:10
 **/
@Component
public class ExcelUtils {


    /**
     * 把Excel的数据解析成 JSON数组。以 {"sheetName":[{数据行}]}的形式返回
     * @param workbook
     * @return
     */
    public Map<String, JSONArray> excelToMap(Workbook workbook){
        Map<String,JSONArray> map=new HashMap<>(1);
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet=workbook.getSheetAt(i);
            String sheetName=sheet.getSheetName();
            map.put(sheetName,sheetToJSONArray(sheet));
        }
        return map;
    }



    public JSONArray sheetToJSONArray(Sheet sheet){
        JSONArray jsonArray=new JSONArray();
        //取出第一行作为key
        Row keyRow=sheet.getRow(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row valueRow=sheet.getRow(i);
            JSONObject object=new JSONObject();
            for (int j = 0; j < valueRow.getLastCellNum(); j++) {
                object.put(keyRow.getCell(j).getStringCellValue(),valueRow.getCell(j).getStringCellValue());
            }
            jsonArray.add(object);
        }
        return jsonArray;
    }

    public List jsonArrayToList(Class clazz,JSONArray jsonArray) throws IllegalAccessException, InstantiationException {
        List list=new ArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj=jsonArray.getJSONObject(i);
            Object entity=clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                if(field.isAnnotationPresent(Excel.class)){
                    Excel excel=field.getAnnotation(Excel.class);
                    String name=excel.name();
                    String value= (String) obj.get(name);
                    field.setAccessible(true);
                    field.set(entity,value);
                }
            }
            list.add(entity);
        }
        return list;
    }


    /**
     * Excel版本检查。 2003的Excel文件后缀为（.xls）使用{@link HSSFWorkbook}
     *                 2006的Excel文件后缀为（.xlsx）使用{@link XSSFWorkbook}
     *
     * @param uploadFile
     * @return
     */
    public static Workbook checkVersion(MultipartFile uploadFile){
        String fileName=uploadFile.getName();
        try {
            if(isExcel2007(fileName)){
                return new XSSFWorkbook(uploadFile.getInputStream());
            }
            else if (isExcel2003(fileName)){
                return new HSSFWorkbook(uploadFile.getInputStream());
            }
            else {return null;}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }




}

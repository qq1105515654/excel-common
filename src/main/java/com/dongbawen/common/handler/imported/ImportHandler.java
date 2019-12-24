package com.dongbawen.common.handler.imported;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author snh
 * @version 1.0
 * @className ImportHandler
 * @description TODO Excel 导入数据处理接口
 * @date 2019/11/11 17:32
 **/
public interface ImportHandler {

    /**
     *  Excel 导入数据处理
     * @param excelTargetClass
     * @param file
     * @return 返回 {sheetName:List}格式的键值对数据
     */
    public Map<String,List> importDataHandler(MultipartFile file,Class ... excelTargetClass);
}

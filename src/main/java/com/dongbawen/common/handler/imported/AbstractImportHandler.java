package com.dongbawen.common.handler.imported;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author snh
 * @version 1.0
 * @className AbstractImportHandler
 * @description TODO 导入处理抽象类
 * @date 2019/11/11 17:41
 **/
public abstract class AbstractImportHandler implements ImportHandler{
    /**
     * 检查文件类型
     * @param multipartFile
     * @return
     */
    public abstract Workbook checkFileType(MultipartFile multipartFile);



}

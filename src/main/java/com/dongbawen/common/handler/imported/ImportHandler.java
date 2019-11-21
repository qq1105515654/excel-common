package com.dongbawen.common.handler.imported;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className ImportHandler
 * @description TODO Excel 导入数据处理接口
 * @date 2019/11/11 17:32
 **/
public interface ImportHandler<T> {

    /**
     *  Excel 导入数据处理
     * @param c
     * @param file
     * @return
     */
    public List<T> importDataHandler(Class<T> c, MultipartFile file);
}

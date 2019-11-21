package com.dongbawen.common.dto;

import lombok.Data;

/**
 * @author snh
 * @version 1.0
 * @className ExcelImportErrorDto
 * @description TODO
 * @date 2019/11/12 9:48
 **/
@Data
public class ExcelImportErrorDto {

    /**
     * 定位到行
     */
    private int row;

    /**
     * 定位到列
     */
    private int column;

    /**
     * 错误消息
     */
    private String message;


    public ExcelImportErrorDto() {}

    public ExcelImportErrorDto(int row, int column, String message) {
        this.row = row;
        this.column = column;
        this.message = message;
    }
}

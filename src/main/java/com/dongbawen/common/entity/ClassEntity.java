package com.dongbawen.common.entity;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelCollections;
import com.dongbawen.common.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className ClassEntity
 * @description TODO 班级信息实体
 * @date 2019/11/7 14:29
 **/
@Data
@ExcelTarget(sheetName = "班级信息")
public class ClassEntity {

    @ExcelCollections
    private List<Student> studentList;

    @Excel(name = "班级编号",index = 0)
    private String id;

    @Excel(name = "班级名",index = 1)
    private String className;

    @Excel(name = "班主任",index = 2,isSharedField = true)
    private String classTeacher;
}

package com.dongbawen.common.entity;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelIgnore;
import com.dongbawen.common.annotation.ExcelTarget;
import lombok.Data;

import java.util.Date;

/**
 * @author snh
 * @version 1.0
 * @className Student
 * @description TODO
 * @date 2019/11/7 11:50
 **/
@Data
@ExcelTarget(sheetName = "学生信息")
public class Student {

    @Excel(name = "编号",index = 0,isRequired = true)
    private String id;

    @Excel(name = "名字",index = 1,isRequired = true)
    private String name;

    @Excel(name = "性别",index = 2,replace = {"男:1","女:2"},isRequired = true)
    private String sex;

    @Excel(name = "年龄",index = 3,isRequired = true)
    private int age;

    @Excel(name = "身份证号码",index = 4,maxLength = "18",minLength = "18",isRequired = true)
    private String idCard;

    @Excel(name = "班主任",index = 5,isRequired = true)
    private String classTeacher;

    @Excel(name = "入校时间",index = 6,isRequired = true,dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ExcelIgnore
    private String createUsername;

    @ExcelIgnore
    private Date modifyTime;

    @ExcelIgnore
    private String modifyUsername;

    public Student(){}

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

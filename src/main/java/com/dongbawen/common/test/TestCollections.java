package com.dongbawen.common.test;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelTarget;
import com.dongbawen.common.entity.Student;
import com.dongbawen.common.handler.annotation.process.ExcelFieldAnnotationHandlerProcess;
import com.dongbawen.common.handler.annotation.process.ExcelTypeAnnotationHandlerProcess;
import com.dongbawen.common.utils.FieldUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * @author snh
 * @version 1.0
 * @className TestCollections
 * @description TODO
 * @date 2019/11/7 17:33
 **/
@Slf4j
public class TestCollections {


    public static void main(String[] args) {
        ExcelTypeAnnotationHandlerProcess<Student, ExcelTarget> annotation=new ExcelTypeAnnotationHandlerProcess<>();
        Student student=new Student();
        student.setAge(18);
        student.setClassTeacher("刘备");
        student.setId("11035035755225");
        student.setIdCard("435120116548613245");
        student.setName("刘禅");
        student.setSex("男");
        student.setCreateTime(new Date());
        student.setCreateUsername("System");
        student.setModifyTime(new Date());
        student.setModifyUsername("System");

        ExcelTarget target=annotation.getAnnotation(student,ExcelTarget.class);

        List<Field> list= FieldUtils.getEndField(Student.class);
        list.forEach(field -> {
            Excel excel=new ExcelFieldAnnotationHandlerProcess<>().getAnnotation(field, Excel.class);
            log.info("Index：{}",excel.index());
            log.info("Name：{}",excel.name());
            log.info("isRequire：{}",excel.isRequired());
            log.info("isSharedField：{}",excel.isSharedField());
        });


//        System.out.println(target.sheetName());
//        //Object object= AnnotationUtils.getAnnotationValue(target,"sheetName");
//        System.out.println(annotation.getSheetName());



    }

}

package com.dongbawen.common.test;

import com.dongbawen.common.annotation.ExcelTarget;
import com.dongbawen.common.entity.Student;
import com.dongbawen.common.handler.annotation.process.ExcelTypeAnnotationHandlerProcess;

/**
 * @author snh
 * @version 1.0
 * @className TestCollections
 * @description TODO
 * @date 2019/11/7 17:33
 **/
public class TestCollections {


    public static void main(String[] args) {
        ExcelTypeAnnotationHandlerProcess<Student, ExcelTarget> annotation=new ExcelTypeAnnotationHandlerProcess<>();
        Student student=new Student();
        ExcelTarget target=annotation.getAnnotation(student,ExcelTarget.class);

        //Object object= AnnotationUtils.getAnnotationValue(target,"sheetName");
        System.out.println(annotation.getSheetName());



    }
}

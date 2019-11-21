package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className ExcelImport
 * @description TODO 标记导入Excel到数据库
 * @date 2019/11/11 17:13
 **/
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelImport {

}

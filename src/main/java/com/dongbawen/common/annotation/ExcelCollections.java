package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className ExcelCollections
 * @description TODO 用于标记一对多的关系导出 Excel
 * @date 2019/11/7 14:14
 **/
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelCollections {



}

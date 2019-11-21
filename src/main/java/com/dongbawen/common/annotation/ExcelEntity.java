package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className ExcelEntity
 * @description TODO 用于标记对象关系一对一的关系
 * @date 2019/11/20 9:11
 **/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelEntity {

}

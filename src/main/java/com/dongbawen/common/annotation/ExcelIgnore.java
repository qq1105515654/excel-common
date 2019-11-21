package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className ExcelIgnore
 * @description TODO 字段忽略标记
 * @date 2019/11/11 16:15
 **/
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelIgnore {

}

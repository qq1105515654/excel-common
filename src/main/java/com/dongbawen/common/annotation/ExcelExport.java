package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className ExcelExport
 * @description TODO 标记导出Excel
 * @date 2019/11/11 17:12
 **/
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelExport {
}

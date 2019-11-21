package com.dongbawen.common.annotation;

import java.lang.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author snh
 * @version 1.0
 * @className ExcelTarget
 * @description TODO 单个Sheet注解
 * @date 2019/11/7 11:34
 **/
@Documented //作用于Javadoc
@Inherited  //可被继承
@Target(ElementType.TYPE) //注解可用于在类上面
@Retention(RetentionPolicy.RUNTIME)//存活阶段：运行期存活、JVM、class文件级别。
public @interface ExcelTarget {

    /**
     * sheet name
     * @return
     */
    String sheetName();

    boolean isNotNull() default true;
}

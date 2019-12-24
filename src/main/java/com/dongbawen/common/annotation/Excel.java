package com.dongbawen.common.annotation;

import java.lang.annotation.*;

/**
 * @author snh
 * @version 1.0
 * @className Excel
 * @description TODO
 * @date 2019/11/7 11:45
 **/
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    String name();

    //导入时间的自定一个格式
    String dateFormat() default "";

    //当前属性所属单元格的下标
    int index();
    //字段最大长度
    String maxLength() default "";
    //字段最低长度
    String minLength() default "";

    String[] replace() default "";



    /**
     * 这个字段仅限在一对多的情况下使用。当前字段对应另一张关系表中的同一个字段数据时。
     * 用于标记共享字段
     * true 为共享字段，Excel导出时会为两个Sheet都加入这个字段。
     * @return
     */
    boolean isSharedField() default false;

    /**
     * 这个属性用于标识在这个属性为共享字段时，必须要填写另外一个对象的类型反射
     * @return
     */
    Class shareFieldClass() default Object.class;

    /**
     * 该字段是否为必填项
     * @return
     * @default true
     */
    boolean isRequired() default false;


}

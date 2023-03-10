package com.chw.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chw
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Vo {
    /**
     *  前台label
     * @return
     */
    public String  value() default "";

    /**
     *  展示在查询区域
     * @return
     */
    public  boolean showInQueryRegion() default  false;

    /**
     *  是否不展示在table 区域
     * @return
     */
    public  boolean notShowInTableRegion() default false;

    /**
     *  对应表单控件类型
     * @return
     */
    public  String  controlType() default "";

    /**
     *  控件初始化参数
     * @return
     */
    public  String  controlInitParam() default  "";
}

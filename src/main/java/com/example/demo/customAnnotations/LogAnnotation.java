package com.example.demo.customAnnotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解3
 * 
 * @author RuiJiang
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE}) // 注解可以被使用在方法，类上面
public @interface LogAnnotation {

	String desc() default "打印日志";
}

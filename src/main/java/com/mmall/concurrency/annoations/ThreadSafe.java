package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：
 * 课程里有来标记【线程安全】的类或者写法
 * Created by Torres
 * 2018-05-16 22:33
 */
@Target(ElementType.TYPE)
//作用类
@Retention(RetentionPolicy.SOURCE)
//作用范围：RetentionPolicy.SOURCE 只在编译时有效 RetentionPolicy.RUNTIME 在运行时有效
public @interface ThreadSafe {
    String value() default "";
}




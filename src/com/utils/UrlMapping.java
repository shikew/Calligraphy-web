package com.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 描述:
 *
 * @author lance
 * 自定义注解
 * @Retention –什么时候使用该注解
 * @Target –注解用于什么地方
 *  RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，
 *  因此可以使用反射机制读取该注解的信息。我们自定义的注解通常使用这种方式。
 *  ElementType.METHOD:用于描述方法
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UrlMapping {
    String value();
}
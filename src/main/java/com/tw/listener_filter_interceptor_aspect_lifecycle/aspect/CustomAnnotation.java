package com.tw.listener_filter_interceptor_aspect_lifecycle.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author David Tian
 * @desc
 * @since 2019-12-07 20:01
 */

@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {

    String value() default "";
}

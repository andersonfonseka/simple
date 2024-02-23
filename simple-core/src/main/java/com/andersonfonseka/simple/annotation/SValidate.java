package com.andersonfonseka.simple.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.andersonfonseka.simple.enums.ValidateEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SValidate {

	String fieldName() default "";

	ValidateEnum[] types();

}

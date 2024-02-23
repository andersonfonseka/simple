package com.andersonfonseka.simple.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.andersonfonseka.simple.enums.ScopeEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SController {

	String name() default "";

	String formName() default "";
	
	ScopeEnum scope();

}

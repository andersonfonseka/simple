package com.andersonfonseka.simple.validation;

import java.lang.reflect.Field;

import com.andersonfonseka.simple.form.SimpleForm;

public class SimpleFormValidator {

	public static void doValidate(SimpleForm form) {

		Field[] fld = form.getClass().getDeclaredFields();

		for (Field field : fld) {
			field.setAccessible(true);
			if (null != field.getAnnotations() && field.getAnnotations().length > 0) {
				if (field.getDeclaredAnnotationsByType(Required.class) != null) {
					try {
						new RequiredValidator().doExecute(field.getName(), String.valueOf(field.get(form)));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}

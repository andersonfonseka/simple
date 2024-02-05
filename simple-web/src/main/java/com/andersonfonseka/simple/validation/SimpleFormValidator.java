package com.andersonfonseka.simple.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.form.SimpleForm;

public class SimpleFormValidator {

	public static List<String> doValidate(SimpleForm form) {

		List<String> errors = new ArrayList<String>();
		Field[] fld = form.getClass().getDeclaredFields();

		for (Field field : fld) {
			field.setAccessible(true);
			if (null != field.getAnnotations() && field.getAnnotations().length > 0) {
				if (field.getDeclaredAnnotationsByType(Required.class) != null) {
					try {
						String result = new RequiredValidator().doExecute(field.getAnnotation(Required.class).value(),
								String.valueOf(field.get(form)));
						if (result.trim().length() > 0) {
							errors.add(result.trim());
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return errors;
	}

}

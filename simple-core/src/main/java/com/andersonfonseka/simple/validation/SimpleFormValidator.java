package com.andersonfonseka.simple.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.annotation.SValidate;
import com.andersonfonseka.simple.enums.ValidateEnum;
import com.andersonfonseka.simple.form.SimpleForm;

public class SimpleFormValidator {

	public static List<String> doValidate(SimpleForm form) {

		List<String> errors = new ArrayList<String>();
		Field[] fld = form.getClass().getDeclaredFields();

		for (Field field : fld) {
			field.setAccessible(true);
			if (null != field.getAnnotations() && field.getAnnotations().length > 0) {
				if (field.getDeclaredAnnotationsByType(SValidate.class) != null) {
					try {
						String result = "";

						if (field.getAnnotation(SValidate.class).types()[0].compareTo(ValidateEnum.REQUIRED) == 0) {
							result = new RequiredValidator().doExecute(field.getAnnotation(SValidate.class).fieldName(),
									String.valueOf(field.get(form)));
						}

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

package com.andersonfonseka.simple.validation;

import java.text.MessageFormat;

public class RequiredValidator {

	public void doExecute(String field, String value) {
		if (value != null && value.trim().length() == 0) {

			String msg = MessageFormat.format("The {0} is required.", field);
			ValidatorMessage vMessage = new ValidatorMessage(field, msg);
			System.out.println(vMessage);

		}
	}

	public static void main(String[] args) {

		String msg = MessageFormat.format("The {0} is required.", "Name");
		System.out.println(msg);
	}

}

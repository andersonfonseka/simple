package com.andersonfonseka.simple.validation;

import java.text.MessageFormat;
import java.util.logging.Logger;

public class RequiredValidator {

	public String doExecute(String field, String value) {
		if (value != null && value.trim().length() == 0) {

			String msg = MessageFormat.format("The {0} is required.", field);
			ValidatorMessage vMessage = new ValidatorMessage(msg, field);

			Logger.getAnonymousLogger().info(vMessage.toString());

			return vMessage.toString();
		}

		return "";
	}

	public static void main(String[] args) {

		String msg = MessageFormat.format("The {0} is required.", "Name");
		System.out.println(msg);
	}

}

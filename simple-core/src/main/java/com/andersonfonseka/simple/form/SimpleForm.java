package com.andersonfonseka.simple.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.andersonfonseka.simple.validation.SimpleFormValidator;

public class SimpleForm {

	private String name;

	private String className;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<String> doValidate(HttpServletRequest req) {
		
		List<String> validatorMessage = SimpleFormValidator.doValidate(this);

		if (!validatorMessage.isEmpty()) {
			req.setAttribute("alert", validatorMessage);
		}
		
		return validatorMessage;
	}
}

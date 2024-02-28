package com.andersonfonseka.project.form;

import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.annotation.SValidate;
import com.andersonfonseka.simple.enums.ValidateEnum;
import com.andersonfonseka.simple.form.SimpleForm;

@SForm
public class LoginForm extends SimpleForm {

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Username")
	private String username = "";

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Password")
	private String password = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

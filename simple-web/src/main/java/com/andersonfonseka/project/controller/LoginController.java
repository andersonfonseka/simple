package com.andersonfonseka.project.controller;

import com.andersonfonseka.project.form.LoginForm;
import com.andersonfonseka.simple.annotation.SController;
import com.andersonfonseka.simple.enums.ScopeEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.servlet.SimpleBaseController;

@SController(formName = "LoginForm", scope = ScopeEnum.REQUEST)
public class LoginController extends SimpleBaseController {

	private static final long serialVersionUID = 1L;

	public String load(SimpleForm form) {

		LoginForm loginForm = (LoginForm) form;
		
		getRequest().setAttribute("loginForm", loginForm);

		return "login";
	}
	
	public String login(SimpleForm form) {

		String forward = "login";
		
		LoginForm loginForm = (LoginForm) form;
		
		getRequest().setAttribute("loginForm", loginForm);
		
		if (form.doValidate(getRequest()).isEmpty()) {
			forward = "project";
		}

		return forward;
	}

	

}

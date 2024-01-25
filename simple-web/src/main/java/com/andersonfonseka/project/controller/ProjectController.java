package com.andersonfonseka.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.servlet.SimpleServlet;

public class ProjectController extends SimpleServlet {

	private static final long serialVersionUID = 1L;

	public void load(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

	public void teste(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;

		System.out.println(projectForm.getName());

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

}

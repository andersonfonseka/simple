package com.andersonfonseka.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.servlet.SimpleServlet;
import com.andersonfonseka.simple.util.Pagination;
import com.andersonfonseka.simple.validation.SimpleFormValidator;

public class ProjectController extends SimpleServlet {

	private static final long serialVersionUID = 1L;

	private List<Project> mapProjects = new ArrayList();

	public ProjectController() {

		for (int i = 0; i < 37; i++) {
			mapProjects.add(new Project("Simple " + i, "Lorem Ipsum is simply dummy"));
		}
	}

	public void load(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		projectForm.setProjects(mapProjects);

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("project", req, resp);
	}

	public void pagination(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		int page = Integer.parseInt(req.getParameter("tPage"));
		int rows = Integer.parseInt(req.getParameter("tRows"));

		projectForm.setProjects(Pagination.getSublist(mapProjects, page, rows));

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("project", req, resp);
	}

	public void execute(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;

		System.out.println(projectForm.getName());
		System.out.println(projectForm.getType());
		System.out.println(projectForm.getFramework());

		SimpleFormValidator.doValidate(projectForm);

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

	public void details(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;

		projectForm.setProjects(mapProjects);

		Logger.getAnonymousLogger().info(projectForm.getId());

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("project", req, resp);
	}

}

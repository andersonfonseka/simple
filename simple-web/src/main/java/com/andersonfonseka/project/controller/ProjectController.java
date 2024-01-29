package com.andersonfonseka.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.servlet.SimpleServlet;
import com.andersonfonseka.simple.util.Pagination;

public class ProjectController extends SimpleServlet {

	private static final long serialVersionUID = 1L;

	private List<Project> mapProjects = new ArrayList();

	public ProjectController() {

		mapProjects.add(new Project("Simple 1", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 2", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 3", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 4", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 5", "Lorem Ipsum is simply dummy"));

		mapProjects.add(new Project("Simple 6", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 7", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 8", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 9", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 10", "Lorem Ipsum is simply dummy"));

		mapProjects.add(new Project("Simple 11", "Lorem Ipsum is simply dummy"));
		mapProjects.add(new Project("Simple 12", "Lorem Ipsum is simply dummy"));

	}

	public void load(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		projectForm.setProjects(mapProjects);

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

	public void pagination(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		int page = Integer.parseInt(req.getParameter("tPage"));
		int rows = Integer.parseInt(req.getParameter("tRows"));

		projectForm.setProjects(Pagination.getSublist(mapProjects, page, rows));

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

	public void execute(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;

		System.out.println(projectForm.getName());
		System.out.println(projectForm.getPassword());
		System.out.println(projectForm.getGenderId());
		System.out.println(projectForm.getType());
		System.out.println(projectForm.getFramework());

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectPage", req, resp);
	}

}

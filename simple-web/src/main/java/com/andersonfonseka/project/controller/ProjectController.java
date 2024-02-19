package com.andersonfonseka.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.mapping.ProjectMapping;
import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.project.repository.ProjectRepository;
import com.andersonfonseka.simple.annotation.Controller;
import com.andersonfonseka.simple.enums.ScopeEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.servlet.SimpleServlet;
import com.andersonfonseka.simple.util.Pagination;

@Controller(name = "projectController", formName = "projectForm", scope = ScopeEnum.REQUEST)
public class ProjectController extends SimpleServlet {

	private static final long serialVersionUID = 1L;

	private ProjectRepository projectRepository;
	
	public ProjectController() {
		this.projectRepository = ProjectRepository.getInstance();
	}

	public void load(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		projectForm.setProjects(this.projectRepository.list());

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("project", req, resp);
	}

	public void pagination(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = new ProjectForm();

		int page = Integer.parseInt(req.getParameter("tPage"));
		int rows = Integer.parseInt(req.getParameter("tRows"));

		projectForm.setProjects(Pagination.getSublist(projectRepository.list(), page, rows));

		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("project", req, resp);
	}
	
	public void startCreate(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {
		
		ProjectForm projectForm = new ProjectForm();
		req.setAttribute("projectForm", projectForm);

		SimpleForward.doForward("projectCreate", req, resp);
	}

	public void create(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;
		
		req.setAttribute("projectForm", projectForm);

		if (form.doValidate(req).isEmpty()) {
			this.projectRepository.add(new ProjectMapping().getMapping(projectForm));
		}

		SimpleForward.doForward("projectCreate", req, resp);
	}

	public void startUpdate(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {
		
		Project project = this.projectRepository.get(req.getParameter("id"));
		
		req.setAttribute("projectForm", new ProjectMapping().getMapping(project));

		SimpleForward.doForward("projectUpdate", req, resp);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp, SimpleForm form)
			throws ServletException, IOException {

		ProjectForm projectForm = (ProjectForm) form;
		
		req.setAttribute("projectForm", projectForm);

		if (form.doValidate(req).isEmpty()) {
			this.projectRepository.edit(new ProjectMapping().getMapping(projectForm));
		}

		SimpleForward.doForward("projectCreate", req, resp);
	}
	

}

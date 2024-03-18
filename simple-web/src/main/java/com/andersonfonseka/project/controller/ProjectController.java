package com.andersonfonseka.project.controller;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.mapping.ProjectMapping;
import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.project.repository.ProjectRepository;
import com.andersonfonseka.project.service.GPTService;
import com.andersonfonseka.simple.annotation.SController;
import com.andersonfonseka.simple.enums.ScopeEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.servlet.SimpleBaseController;
import com.andersonfonseka.simple.util.Pagination;

@SController(formName = "ProjectForm", scope = ScopeEnum.REQUEST)
public class ProjectController extends SimpleBaseController {

	private static final long serialVersionUID = 1L;

	private ProjectRepository projectRepository;

	public ProjectController() {
		this.projectRepository = ProjectRepository.getInstance();
	}

	public String load(SimpleForm form) {

		ProjectForm projectForm = new ProjectForm();

		projectForm.setProjects(this.projectRepository.list());

		getRequest().setAttribute("projectForm", projectForm);

		return "project";
	}

	public String pagination(SimpleForm form) {

		ProjectForm projectForm = new ProjectForm();

		int page = Integer.parseInt(getRequest().getParameter("tPage"));
		int rows = Integer.parseInt(getRequest().getParameter("tRows"));

		projectForm.setProjects(Pagination.getSublist(projectRepository.list(), page, rows));

		getRequest().setAttribute("projectForm", projectForm);

		return "project";
	}

	public String startCreate(SimpleForm form) {

		ProjectForm projectForm = new ProjectForm();
		getRequest().setAttribute("projectForm", projectForm);

		return "projectCreate";
	}

	public String create(SimpleForm form) {

		ProjectForm projectForm = (ProjectForm) form;

		getRequest().setAttribute("projectForm", projectForm);

		if (form.doValidate(getRequest()).isEmpty()) {

			Project project = new ProjectMapping().getMapping(projectForm);

			String sentenca = "Crie uma descri��o expandida para " + project.getDescription();

			try {
				project.setExpandedDescription(new GPTService().generate(sentenca));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.projectRepository.add(project);
		}

		return "project";
	}

	public String startUpdate(SimpleForm form) {

		Project project = this.projectRepository.get(getRequest().getParameter("id"));

		getRequest().setAttribute("projectForm", new ProjectMapping().getMapping(project));

		return "projectUpdate";
	}

	public String update(SimpleForm form) {

		ProjectForm projectForm = (ProjectForm) form;

		getRequest().setAttribute("projectForm", projectForm);

		if (form.doValidate(getRequest()).isEmpty()) {
			this.projectRepository.edit(new ProjectMapping().getMapping(projectForm));
		}

		return "projectCreate";
	}

}

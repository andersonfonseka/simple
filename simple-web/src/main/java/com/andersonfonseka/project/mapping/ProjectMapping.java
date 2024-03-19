package com.andersonfonseka.project.mapping;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.model.Project;

public class ProjectMapping {

	public Project getMapping(ProjectForm form) {

		Project project = new Project();

		project.setId(form.getId());
		project.setName(form.getName());
		project.setDescription(form.getDescription());

		return project;
	}

	public ProjectForm getMapping(Project proj) {

		ProjectForm form = new ProjectForm();

		form.setId(proj.getId());
		form.setName(proj.getName());
		form.setDescription(proj.getDescription());
		form.setExpandedDescription(proj.getExpandedDescription());
		form.setFuncionalities(proj.getFuncionalities());
		form.setTestCases(proj.getTestScenarios());

		return form;
	}

}

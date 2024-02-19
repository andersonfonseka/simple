package com.andersonfonseka.project.mapping;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.model.Project;

public class ProjectMapping {
	
	public Project getMapping(ProjectForm form) {
		
		Project project = new Project();
		
		project.setId(form.getId());
		project.setName(form.getName());
		project.setDescription(form.getDescription());
		project.setApproach(form.getApproach());
		project.setFramework(form.getFramework());
		
		return project;
	}
	
	public ProjectForm getMapping(Project proj) {
		
		ProjectForm projectForm = new ProjectForm();
		
		projectForm.setId(proj.getId());
		projectForm.setName(proj.getName());
		projectForm.setDescription(proj.getDescription());
		projectForm.setApproach(proj.getApproach());
		projectForm.setFramework(proj.getFramework());
		
		return projectForm;
	}


}

package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.annotation.SValidate;
import com.andersonfonseka.simple.enums.ValidateEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.taghandler.model.SelectItem;

@SForm
public class ProjectForm extends SimpleForm {

	private String id;

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Name")
	private String name = "";

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Description")
	private String description = "";

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Management Approach")
	private String approach;

	private List<SelectItem> approachList = new ArrayList<>();

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Management Framework")
	private String framework = "";

	private List<SelectItem> frameworkList = new ArrayList<>();

	private List<Project> projects = new ArrayList<Project>();

	public ProjectForm() {

		approachList.add(new SelectItem("", "Choose one..."));
		approachList.add(new SelectItem("1", "Predictive"));
		approachList.add(new SelectItem("2", "Adaptative"));

		frameworkList.add(new SelectItem("1", "Scrum"));
		frameworkList.add(new SelectItem("2", "Kanban"));
		frameworkList.add(new SelectItem("3", "PMBoK"));
		frameworkList.add(new SelectItem("4", "RUP"));

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApproach() {
		return approach;
	}

	public void setApproach(String approach) {
		this.approach = approach;
	}

	public List<SelectItem> getApproachList() {
		return approachList;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public List<SelectItem> getFrameworkList() {
		return frameworkList;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}

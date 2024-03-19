package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.project.model.TestScenario;
import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.annotation.SValidate;
import com.andersonfonseka.simple.enums.ValidateEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.youbenzi.mdtool.tool.MDTool;

@SForm
public class ProjectForm extends SimpleForm {

	private String id;

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Name")
	private String name = "";

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Description")
	private String description = "";

	private String expandedDescription;

	private String funcionalities;

	private List<Project> projects = new ArrayList<Project>();

	private List<TestScenario> testCases = new ArrayList<TestScenario>();

	private TestScenario testScenario;

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

	public String getExpandedDescription() {
		return expandedDescription;
	}

	public void setExpandedDescription(String expandedDescription) {
		this.expandedDescription = expandedDescription;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getFuncionalities() {
		return MDTool.markdown2Html(funcionalities);
	}

	public void setFuncionalities(String funcionalities) {
		this.funcionalities = funcionalities;
	}

	public List<TestScenario> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<TestScenario> testCases) {
		this.testCases = testCases;
	}

	public TestScenario getTestScenario() {
		return testScenario;
	}

	public void setTestScenario(TestScenario testScenario) {
		this.testScenario = testScenario;
	}

}

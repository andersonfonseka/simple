package com.andersonfonseka.project.model;

public class TestScenario {

	private String id;

	private String projectId;

	private String funcionality;

	private String testingScenario = "";

	private String testingScenarioDiagram = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFuncionality() {
		return funcionality;
	}

	public void setFuncionality(String funcionality) {
		this.funcionality = funcionality;
	}

	public String getTestingScenario() {
		return testingScenario;
	}

	public void setTestingScenario(String testingScenario) {
		this.testingScenario = testingScenario;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTestingScenarioDiagram() {
		return testingScenarioDiagram;
	}

	public void setTestingScenarioDiagram(String testingScenarioDiagram) {
		this.testingScenarioDiagram = testingScenarioDiagram;
	}

}

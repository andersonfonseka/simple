package com.andersonfonseka.project.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String id;

	private String name = "";

	private String description = "";

	private String expandedDescription;

	private String funcionalities;

	private List<TestScenario> testScenarios = new ArrayList();

	private List<TestScenarioDiagram> testScenariosDiagram = new ArrayList();

	private String remove = "Remove";

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public String getFuncionalities() {
		return funcionalities;
	}

	public void setFuncionalities(String funcionalities) {
		this.funcionalities = funcionalities;
	}

	public List<TestScenario> getTestScenarios() {
		return testScenarios;
	}

	public void addTestScenarios(TestScenario testScenarios) {
		this.testScenarios.add(testScenarios);
	}

	public List<TestScenarioDiagram> getTestScenariosDiagram() {
		return testScenariosDiagram;
	}

	public void addTestScenariosDiagram(TestScenarioDiagram testScenariosDiagram) {
		this.testScenariosDiagram.add(testScenariosDiagram);
	}

	public String getRemove() {
		return remove;
	}

	public void setRemove(String remove) {
		this.remove = remove;
	}

}

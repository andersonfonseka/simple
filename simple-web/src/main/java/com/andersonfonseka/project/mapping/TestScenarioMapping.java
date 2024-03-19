package com.andersonfonseka.project.mapping;

import com.andersonfonseka.project.form.TestScenarioForm;
import com.andersonfonseka.project.model.TestScenario;

public class TestScenarioMapping {

	public TestScenario getMapping(TestScenarioForm form) {

		TestScenario project = new TestScenario();

		project.setFuncionality(form.getFuncionality());
		project.setProjectId(form.getProjectId());
		project.setTestingScenario(form.getTestingScenario());
		project.setTestingScenarioDiagram(form.getTestingScenarioDiagram());

		return project;
	}

	public TestScenarioForm getMapping(TestScenario proj) {

		TestScenarioForm form = new TestScenarioForm();

		form.setId(proj.getId());
		form.setFuncionality(proj.getFuncionality());
		form.setProjectId(proj.getProjectId());
		form.setTestingScenario(proj.getTestingScenario());
		form.setTestingScenarioDiagram(proj.getTestingScenarioDiagram());

		return form;
	}

}

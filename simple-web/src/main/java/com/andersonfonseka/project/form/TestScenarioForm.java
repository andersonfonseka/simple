package com.andersonfonseka.project.form;

import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.form.SimpleForm;
import com.youbenzi.mdtool.tool.MDTool;

@SForm
public class TestScenarioForm extends SimpleForm {

	private String id;

	private String projectId;

	private String funcionality;

	private String testingScenario;

	private String testingScenarioDiagram;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFuncionality() {
		return funcionality;
	}

	public void setFuncionality(String funcionality) {
		this.funcionality = funcionality;
	}

	public String getTestingScenario() {
		return MDTool.markdown2Html(testingScenario);
	}

	public void setTestingScenario(String testingScenario) {
		this.testingScenario = testingScenario;
	}

	public String getTestingScenarioDiagram() {
		return testingScenarioDiagram;
	}

	public void setTestingScenarioDiagram(String testingScenarioDiagram) {
		this.testingScenarioDiagram = testingScenarioDiagram;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

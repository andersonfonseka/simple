package com.andersonfonseka.project.controller;

import java.util.List;

import com.andersonfonseka.project.form.ProjectForm;
import com.andersonfonseka.project.mapping.ProjectMapping;
import com.andersonfonseka.project.mapping.TestScenarioMapping;
import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.project.model.TestScenario;
import com.andersonfonseka.project.repository.ProjectRepository;
import com.andersonfonseka.project.repository.TestScenarioRepository;
import com.andersonfonseka.project.service.GPTService;
import com.andersonfonseka.project.util.UtilFuncionalMarkdown;
import com.andersonfonseka.simple.annotation.SController;
import com.andersonfonseka.simple.enums.ScopeEnum;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.servlet.SimpleBaseController;
import com.andersonfonseka.simple.util.Pagination;

@SController(formName = "ProjectForm", scope = ScopeEnum.REQUEST)
public class ProjectController extends SimpleBaseController {

	private static final long serialVersionUID = 1L;

	private GPTService gptService = new GPTService();

	private ProjectRepository projectRepository;

	private TestScenarioRepository testScenarioRepository;

	public ProjectController() {
		this.projectRepository = ProjectRepository.getInstance();
		this.testScenarioRepository = TestScenarioRepository.getInstance();
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

	public String startFeature(SimpleForm form) {

		Project project = this.projectRepository.get(getRequest().getParameter("id"));

		getRequest().setAttribute("projectForm", new ProjectMapping().getMapping(project));

		return "projectFeature";
	}

	public String startFunctionality(SimpleForm form) {

		Project project = this.projectRepository.get(getRequest().getParameter("id"));

		getRequest().setAttribute("projectForm", new ProjectMapping().getMapping(project));

		return "projectFunctionality";
	}

	public String startTestCases(SimpleForm form) {

		Project project = this.projectRepository.get(getRequest().getParameter("id"));

		getRequest().setAttribute("projectForm", new ProjectMapping().getMapping(project));

		return "projectTestCases";
	}

	public String startTestCasesDiagram(SimpleForm form) {

		TestScenario testScenario = this.testScenarioRepository.get(getRequest().getParameter("id"));
		getRequest().setAttribute("testScenario", new TestScenarioMapping().getMapping(testScenario));

		return "projectTestCaseDiagram";

	}

	public String startTestCasesDetails(SimpleForm form) {

		TestScenario testScenario = this.testScenarioRepository.get(getRequest().getParameter("id"));

		if (testScenario.getTestingScenario() != null & testScenario.getTestingScenario().trim().length() == 0) {

			String sentencaFuncionalDetalhada = "Descreva em detalhes os casos de testes para "
					+ testScenario.getFuncionality()
					+ " contendo cenários de sucesso, insucesso e passos em formato markdown";

			try {
				testScenario.setTestingScenario(gptService.generate(sentencaFuncionalDetalhada));
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sentencaTestCaseDiagram = "Crie um diagrama de fluxo de informação para os cenários de testes da funcionalidade "
					+ testScenario.getFuncionality() + " em mermaid js";

			try {

				String strDiagram = gptService.generate(sentencaTestCaseDiagram);

				int idxs = strDiagram.indexOf("flowchart");

				if (idxs == -1) {
					idxs = strDiagram.indexOf("graph");
				}

				int idxe = strDiagram.lastIndexOf("```");

				testScenario.setTestingScenarioDiagram(strDiagram.substring(idxs, idxe));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		getRequest().setAttribute("testScenario", new TestScenarioMapping().getMapping(testScenario));

		return "projectTestCaseDetails";
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

			try {

				Project project = new ProjectMapping().getMapping(projectForm);
				project = this.projectRepository.add(project);

				String sentencaFuncionality = "Exiba todos os requisitos funcionais exaustivamente, sendo eles: obrigatórios e desejáveis em uma lista no formato markdown para "
						+ project.getDescription();

				String resultFunc = gptService.generate(sentencaFuncionality);

				project.setFuncionalities(resultFunc);

				List<String> funcList = UtilFuncionalMarkdown.getFuncionalities(resultFunc);

				for (String string : funcList) {

					TestScenario scenario = new TestScenario();
					scenario.setFuncionality(string);

					scenario.setProjectId(project.getId());
					project.addTestScenarios(scenario);

					testScenarioRepository.add(scenario);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			projectForm.setProjects(this.projectRepository.list());
			getRequest().setAttribute("projectForm", projectForm);
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

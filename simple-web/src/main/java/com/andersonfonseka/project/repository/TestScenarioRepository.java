package com.andersonfonseka.project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.project.model.TestScenario;

public class TestScenarioRepository {

	private static TestScenarioRepository INSTANCE;

	private Map<String, TestScenario> testCollection = new HashMap<>();

	private TestScenarioRepository() {
	}

	public static TestScenarioRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TestScenarioRepository();
		}

		return INSTANCE;
	}

	public void add(TestScenario project) {
		project.setId(UUID.randomUUID().toString());
		this.testCollection.put(project.getId(), project);
	}

	public TestScenario get(String id) {
		return this.testCollection.get(id);
	}

	public void edit(TestScenario project) {
		this.testCollection.put(project.getId(), project);
	}

	public void remove(TestScenario project) {
		this.testCollection.remove(project.getId());
	}

	public List<TestScenario> list(Project project) {

		List<TestScenario> subList = new ArrayList<>();

		for (TestScenario testScenario : testCollection.values()) {
			if (testScenario.getProjectId().equals(project.getId())) {
				subList.add(testScenario);
			}
		}

		return subList;

	}

}

package com.andersonfonseka.project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.andersonfonseka.project.model.Project;

public class ProjectRepository {

	private static ProjectRepository INSTANCE;

	private Map<String, Project> projects = new HashMap<>();

	private ProjectRepository() {
	}

	public static ProjectRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProjectRepository();
		}

		return INSTANCE;
	}

	public Project add(Project project) {
		project.setId(UUID.randomUUID().toString());
		this.projects.put(project.getId(), project);
		return project;
	}

	public Project get(String id) {
		return this.projects.get(id);
	}

	public void edit(Project project) {
		this.projects.put(project.getId(), project);
	}

	public void remove(Project project) {
		this.projects.remove(project.getId());
	}

	public List<Project> list() {
		return new ArrayList<Project>(this.projects.values());
	}

}

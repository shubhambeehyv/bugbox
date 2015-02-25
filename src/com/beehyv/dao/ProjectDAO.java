package com.beehyv.dao;
import java.util.List;

import com.beehyv.modal.Project;

public interface ProjectDAO {
	
	public List<Project> getProjects();
	public Project getProjectById(int idProject);
	public void addProject(Project newProject);
	
}

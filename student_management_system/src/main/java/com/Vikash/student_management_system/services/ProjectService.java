package com.Vikash.student_management_system.services;

import java.util.List;

import com.Vikash.student_management_system.entities.ProjectDetails;


public interface ProjectService {
	
	ProjectDetails addProject(ProjectDetails project, Integer studentId);
	
	ProjectDetails getProject(Integer projectId);
	
	List<ProjectDetails> getProjectOfStudents(Integer studentId);

}

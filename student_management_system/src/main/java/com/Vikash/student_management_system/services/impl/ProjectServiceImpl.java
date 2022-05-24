package com.Vikash.student_management_system.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.student_management_system.entities.ProjectDetails;
import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.repo.ProjectRepository;
import com.Vikash.student_management_system.repo.StudentRepository;
import com.Vikash.student_management_system.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	
	@Autowired
	private StudentRepository studentRepository;

	
	@Autowired
	private ProjectRepository projectRepository;



	@Override
	public ProjectDetails getProject(Integer projectId) {
		
		ProjectDetails project = this.projectRepository.findById(projectId).get();
		return project;
	}

	@Override
	public ProjectDetails addProject(ProjectDetails project, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		project.setStudent(student);

		ProjectDetails project1 = this.projectRepository.save(project);

		return project1;
	}

	@Override
	public List<ProjectDetails> getProjectOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		return this.projectRepository.findByStudent(student);

	}

}

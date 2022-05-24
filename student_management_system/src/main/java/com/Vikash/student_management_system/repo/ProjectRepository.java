package com.Vikash.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.student_management_system.entities.ProjectDetails;
import com.Vikash.student_management_system.entities.Student;


public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer>{
	
	
	List<ProjectDetails> findByProjectTitle(String projectTitle);

	List<ProjectDetails> findByStudent(Student student);

}

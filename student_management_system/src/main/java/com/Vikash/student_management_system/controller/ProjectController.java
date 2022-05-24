package com.Vikash.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vikash.student_management_system.entities.ProjectDetails;
import com.Vikash.student_management_system.services.ProjectService;


@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public ResponseEntity<ProjectDetails> addProject(@PathVariable Integer studentId,@RequestBody ProjectDetails project)
	{
		ProjectDetails addedProject = projectService.addProject(project,studentId);
		return new ResponseEntity<ProjectDetails>(addedProject, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/project")
	public ResponseEntity<List<ProjectDetails>> getAllByStudent(@PathVariable Integer studentId) {
		
		
		return ResponseEntity.ok(this.projectService.getProjectOfStudents(studentId));
	}


}

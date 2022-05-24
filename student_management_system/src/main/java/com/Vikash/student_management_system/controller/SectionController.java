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

import com.Vikash.student_management_system.entities.Section;
import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.services.SectionService;



@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	@PostMapping("/section")
	public ResponseEntity<Section> createSection(@PathVariable Integer studentId,@RequestBody Section section)
	{
		Section addedSection = sectionService.addSection(section,studentId);
		return new ResponseEntity<Section>(addedSection, HttpStatus.CREATED);
		
	}
	
	//Get Section Of Student
	
		@GetMapping("/section")
		public ResponseEntity<Student> getSectionOfStudent(@PathVariable Integer studentId) {
			return ResponseEntity.ok(this.sectionService.getSectionOfStudent(studentId));
		}
		
		//Get All Students in a Section
		
		@GetMapping("/section/{sectionId}")
		public ResponseEntity<List<Student>> getStudentsBySection(@PathVariable Integer sectionId) {
			return ResponseEntity.ok(this.sectionService.getStudentsOfSection(sectionId));
		}
		@GetMapping("/section/get")
		public ResponseEntity<List<Section>> getsection() {
			return new ResponseEntity<List<Section>>(sectionService.getsection(), HttpStatus.OK);
		}

}

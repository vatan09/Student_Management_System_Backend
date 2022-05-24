package com.Vikash.student_management_system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.entities.StudentSection;
import com.Vikash.student_management_system.repo.StudentRepository;
import com.Vikash.student_management_system.repo.StudentSectionRepo;
import com.Vikash.student_management_system.services.StudentSectionService;

@Service
public class StudentSectionServiceImplJpa implements StudentSectionService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentSectionRepo studentSectionRepo;

	@Override
	public StudentSection addStudentSection(StudentSection studentsection, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		
		studentsection.setStudent(student);
		StudentSection studentsection1 = this.studentSectionRepo.save(studentsection);
		return studentsection1;
	}

	@Override
	public List<StudentSection> getStudentSectionsOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		
		return this.studentSectionRepo.findByStudent(student);
	}

}


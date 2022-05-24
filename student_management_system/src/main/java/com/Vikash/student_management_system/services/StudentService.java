package com.Vikash.student_management_system.services;

import java.util.List;

import com.Vikash.student_management_system.entities.Student;


public interface StudentService {
	
	//adding student
	Student addStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudent(Integer studentId);
	
	void deleteStudent(Integer studentId);
	
	Student updateStudent(Student student,Integer studentId);
	

}

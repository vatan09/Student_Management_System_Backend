package com.Vikash.student_management_system.services;

import java.util.List;

import com.Vikash.student_management_system.entities.StudentSection;


public interface StudentSectionService {
	
	StudentSection addStudentSection(StudentSection studentsection,Integer studentId);
	
	List<StudentSection> getStudentSectionsOfStudents(Integer studentId);

}

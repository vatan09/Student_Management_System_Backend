package com.Vikash.student_management_system.services;

import java.util.List;

import com.Vikash.student_management_system.entities.Section;
import com.Vikash.student_management_system.entities.Student;

public interface SectionService {

	
public Section addSection(Section section, Integer studentId);
	
	List<Student> getStudentsOfSection(Integer sectionId);
	
	Student getSectionOfStudent(Integer studentId);
	List<Section> getsection();
}


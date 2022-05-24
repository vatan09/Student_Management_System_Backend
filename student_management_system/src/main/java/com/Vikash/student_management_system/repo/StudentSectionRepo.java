package com.Vikash.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.entities.StudentSection;


public interface StudentSectionRepo extends JpaRepository<StudentSection, Integer>{
	
	List<StudentSection> findByStudent(Student student);

}

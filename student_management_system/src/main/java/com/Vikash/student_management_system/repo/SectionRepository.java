package com.Vikash.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.student_management_system.entities.Section;
import com.Vikash.student_management_system.entities.Student;

public interface SectionRepository extends JpaRepository<Section, Integer>{

	List<Section> findByStudent(Student student);
	
	List<Section> findBySectionName(String sectionName);
	

}

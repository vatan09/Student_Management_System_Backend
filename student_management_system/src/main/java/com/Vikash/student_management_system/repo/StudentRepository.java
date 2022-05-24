package com.Vikash.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.student_management_system.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);
		
	//List<Student> findByCity(String city);
		
}

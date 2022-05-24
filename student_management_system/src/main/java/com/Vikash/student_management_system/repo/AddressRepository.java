package com.Vikash.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vikash.student_management_system.entities.Address;
import com.Vikash.student_management_system.entities.Student;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

	
//
//	List<Address> findByStreet(String street);
//	
//	List<Address> findByCity(String city);
	
	List<Address> findByStudent(Student student);
		
		
		
}

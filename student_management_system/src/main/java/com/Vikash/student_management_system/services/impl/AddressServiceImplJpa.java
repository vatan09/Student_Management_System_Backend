package com.Vikash.student_management_system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.student_management_system.entities.Address;
import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.repo.AddressRepository;
import com.Vikash.student_management_system.repo.StudentRepository;
import com.Vikash.student_management_system.services.AddressService;

@Service
public class AddressServiceImplJpa implements AddressService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address addAddress(Address address, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		address.setStudent(student);

		Address address1 = this.addressRepository.save(address);

		return address1;
	}

	@Override
	public List<Address> getAddressOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		return this.addressRepository.findByStudent(student);
	}
	@Override
	public Address getAddress(Integer addressId) {
		// TODO Auto-generated method stub
		Address address=this.addressRepository.findById(addressId).get();
		return address;
	}

	@Override
	public void deleteAddress(Integer addressId) {
		// TODO Auto-generated method stub
		Address address=this.addressRepository.findById(addressId).get();
		this.addressRepository.delete(address);
	}

	@Override
	public Address updateAddress(Address address, Integer addressId) {
		// TODO Auto-generated method stub
		
		Address updateAddress=this.addressRepository.save(address);
		return updateAddress;
	}
	

}

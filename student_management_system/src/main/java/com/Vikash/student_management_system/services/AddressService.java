package com.Vikash.student_management_system.services;
import java.util.List;

import com.Vikash.student_management_system.entities.Address;


public interface AddressService {
	
    Address addAddress(Address address, Integer studentId);
	
	List<Address> getAddressOfStudents(Integer studentId);
	
	Address getAddress(Integer addressId);
	
	void deleteAddress(Integer addressId);
	
	Address updateAddress(Address address, Integer addressId);

}

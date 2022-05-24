package com.Vikash.student_management_system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vikash.student_management_system.entities.Address;
import com.Vikash.student_management_system.services.AddressService;


@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	//Add Address
	
	@PostMapping("/address")
	public ResponseEntity<Address> addAddress(@PathVariable Integer studentId ,@RequestBody Address address) {
		Address addedAddress = addressService.addAddress(address,studentId);
		return new ResponseEntity<Address>(addedAddress, HttpStatus.CREATED);
	}
	//Get Address
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllByStudent(@PathVariable Integer studentId) {
		return ResponseEntity.ok(this.addressService.getAddressOfStudents(studentId));
	}



	
	@GetMapping("/address/{addressId}")
	public ResponseEntity<Address> getAddress(@PathVariable Integer addressId) {

		Address address = this.addressService.getAddress(addressId);
		return new ResponseEntity<Address>(HttpStatus.OK);

	}

	// delete

	@DeleteMapping("/address/{addressId}")
	public ResponseEntity<Map<String, Object>> deleteAddress(@PathVariable Integer addressId) {
		this.addressService.deleteAddress(addressId);
		return new ResponseEntity<>(Map.of("message", "address deleted successfully"), HttpStatus.OK);
	}

	// update

	@PutMapping("/{addressId}/address")
	public ResponseEntity<Address> updateAddress(@PathVariable Integer studentId,@RequestBody Address address, @PathVariable Integer addressId) {
		Address updateAddress = this.addressService.updateAddress(address, addressId);
		return ResponseEntity.ok(updateAddress);

	}
}

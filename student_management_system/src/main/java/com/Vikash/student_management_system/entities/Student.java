package com.Vikash.student_management_system.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="student")
public class Student {

@Id
	private int id;
@Column(name = "student_name", length = 500, nullable = false)
	private String name;
	private String email;
	private String phone;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<>();
     
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProjectDetails> project = new HashSet<>();
    
	
	@ManyToOne
	private Section section;
//	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<StudentSection> sections= new HashSet<>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	private Student(int id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		
	}



	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
//	public Fee getFee() {
//		return fee;
//	}
//
//	public void setFee(Fee fee) {
//		this.fee = fee;
//	}
//
//}
package com.Vikash.student_management_system.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Section {

	@Id
	private int sectionId;
	private String sectionName;
	
//
//	@OneToMany
//	private List<Student> student;

	@JsonIgnore
	@OneToMany(mappedBy = "section", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Student> student = new ArrayList<>();

	@OneToMany(mappedBy = "section")
	private Set<StudentSection> students = new HashSet<>();
	
	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}





}

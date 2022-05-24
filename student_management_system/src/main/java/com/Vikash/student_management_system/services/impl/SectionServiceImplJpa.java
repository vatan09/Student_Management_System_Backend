package com.Vikash.student_management_system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.student_management_system.entities.Section;
import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.repo.SectionRepository;
import com.Vikash.student_management_system.repo.StudentRepository;
import com.Vikash.student_management_system.services.SectionService;

@Service
public class SectionServiceImplJpa implements SectionService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	public Section addSection(Section section, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		student.setSection(section);
		String name = student.getName();
		List<Student> s1 = this.studentRepository.findByName(name);
		section.setStudent(s1);

		Section section1 = this.sectionRepository.save(section);

		return section1;
	}

	@Override
	public List<Student> getStudentsOfSection(Integer sectionId) {
		Section section  = this.sectionRepository.findById(sectionId).get();
		List<Student> student1 = section.getStudent();
		
		return student1;
	}



	@Override
	public Student getSectionOfStudent(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		return student;
	}
	@Override
	public List<Section> getsection() {
		// TODO Auto-generated method stub
		List<Section>section=this.sectionRepository.findAll();
		return section;
	}

}

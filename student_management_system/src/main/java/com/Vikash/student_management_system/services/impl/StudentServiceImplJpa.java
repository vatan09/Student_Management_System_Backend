package com.Vikash.student_management_system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vikash.student_management_system.entities.Student;
import com.Vikash.student_management_system.repo.StudentRepository;
import com.Vikash.student_management_system.services.StudentService;

@Service
public class StudentServiceImplJpa implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student savedStudent=this.studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student>students=this.studentRepository.findAll();
		return students;
	}

	@Override
	public Student getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student student=this.studentRepository.findById(studentId).get();
		return student;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student student=this.studentRepository.findById(studentId).get();
		this.studentRepository.delete(student);
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		// TODO Auto-generated method stub
		student.setId(studentId);
		Student updatedStudent=this.studentRepository.save(student);
		return updatedStudent;
	}
	

}

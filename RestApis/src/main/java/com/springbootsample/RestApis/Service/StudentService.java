package com.springbootsample.RestApis.Service;

import java.util.List;

import com.springbootsample.RestApis.Model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	Student findById(Long id);
	List<Student> findAll();
	Student updateStudentById(Long id,Student student);
	void deleteStudentById(Long id);
	
	

}

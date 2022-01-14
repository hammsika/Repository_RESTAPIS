package com.springbootsample.RestApis.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsample.RestApis.Exception.StudentNotFoundException;
import com.springbootsample.RestApis.Model.Student;
import com.springbootsample.RestApis.Repository.StudentRepository;
import com.springbootsample.RestApis.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public Student findById(Long id) {
		Student s=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student","Id",id));
		return s;
	}

	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudentById(Long id, Student student) {
		Student s=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student","Id",id));
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		studentRepository.save(s);
		return s;
	}

	@Override
	public void deleteStudentById(Long id) {
		Student s=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student","Id",id));
		studentRepository.delete(s);
		
	}
	
	

}

package com.springbootsample.RestApis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsample.RestApis.Model.Student;
import com.springbootsample.RestApis.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Student>(studentService.findById(id),HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<Student> getAllStudent()
	{
		return studentService.findAll();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id") Long id,@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.updateStudentById(id, student),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public String deleteStudentById(@PathVariable("id") Long id)
	{
		studentService.deleteStudentById(id);
		return "Student succefully deleted";
	}
	
	
	

}

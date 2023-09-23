package com.MyApp.CRUD.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyApp.CRUD.Entity.Student;
import com.MyApp.CRUD.Service.StudentService;



@RestController
@RequestMapping(value= "/")
public class StudentController {
	@Autowired
	StudentService studentService;	
	
	@PostMapping(value="/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
		
	}
	@GetMapping
	public String getStudent()
	{
		return "working";
	}
	@GetMapping(value="/getPassedStudents")
	public List<Student> getPassedStudents()
	{
		return studentService.getPassedStudents();
	}

}

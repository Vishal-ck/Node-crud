package com.MyApp.CRUD.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyApp.CRUD.Entity.Student;
import com.MyApp.CRUD.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public Student addStudent(Student student)
	{
		return studentRepo.save(student);
	}

	public List<Student> getPassedStudents()
	{
		return studentRepo.getPassed();
	}
}

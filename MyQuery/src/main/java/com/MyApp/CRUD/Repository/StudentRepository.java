package com.MyApp.CRUD.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MyApp.CRUD.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	@Query("Select a from Student a where a.passed=true")
	public List<Student> getPassed();
}

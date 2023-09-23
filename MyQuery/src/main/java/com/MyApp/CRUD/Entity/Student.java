package com.MyApp.CRUD.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private int score;
	private boolean passed;
	

}

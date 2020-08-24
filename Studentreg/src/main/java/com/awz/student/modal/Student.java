package com.awz.student.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;	  
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@Column(name="ROLL_NUMBER")
	private String rollNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public Student(Long id, String studentName, String rollNumber) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.rollNumber = rollNumber;
	}

	public Student() {
		
	}


	
	
}

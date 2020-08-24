package com.awz.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awz.student.modal.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findById(Long id);

    
}
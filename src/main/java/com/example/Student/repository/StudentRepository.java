package com.example.Student.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.Entity.Student;


public interface StudentRepository  extends JpaRepository<Student,Long>{

}

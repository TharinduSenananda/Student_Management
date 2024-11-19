package com.example.Student.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Student.Entity.Student;

import jakarta.transaction.Transactional;


public interface StudentRepository  extends JpaRepository<Student,Long>{
    List<Student> findByYearOfEnrollment(String yearOfEnrollment);
    
    @Query("SELECT s.Department FROM Student s WHERE s.id = :id")
    String findDepartmentByStudentId(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.yearOfEnrollment = :yearOfEnrollment")
    void deleteByYearOfEnrollment(String yearOfEnrollment);

}

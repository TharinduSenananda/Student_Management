package com.example.Student.service;
import java.util.List;

import com.example.Student.Entity.Student;
public interface StudentService {

    Student saveStudent(Student student);
    List <Student> getAllStudent();
    Student getStudentById(Long id);
    Student updateStudent(Student student, Long id);
    void deleteStudent (Long id);

    

}

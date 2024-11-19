package com.example.Student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Entity.Student;
import com.example.Student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        // TODO Auto-generated method stub
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
       return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        // TODO Auto-generated method stub
        Optional<Student> student =studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        // TODO Auto-generated method stub
       Student existingStudent=studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       existingStudent.setEmail(student.getEmail());
       existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
       existingStudent.setDepartment(student.getDepartment());
       
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        // TODO Auto-generated method stub
       studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
       studentRepository.deleteById(id);
    }
    @Override
    public List<Student> getStudentsByYearOfEnrollment(String yearOfEnrollment) {
        return studentRepository.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String getDepartmentByStudentId(Long id) {
        return studentRepository.findDepartmentByStudentId(id);
    }

    @Override
    public void deleteStudentsByYearOfEnrollment(String yearOfEnrollment) {
        studentRepository.deleteByYearOfEnrollment(yearOfEnrollment);
    }

    
    
}










package com.example.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Entity.Student;
import com.example.Student.service.StudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
            return  new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);

    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable("id") long studentid){
        return new ResponseEntity<Student>(studentService.getStudentById(studentid),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudernt(@PathVariable("id") long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);

    }

    @GetMapping("/year/{yearOfEnrollment}")
    public ResponseEntity<List<Student>> getStudentsByYearOfEnrollment(@PathVariable("yearOfEnrollment") String yearOfEnrollment) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByYearOfEnrollment(yearOfEnrollment), HttpStatus.OK);
    }
    @GetMapping("{id}/department")
    public ResponseEntity<String> getDepartmentByStudentId(@PathVariable("id") Long id) {
        return new ResponseEntity<String>(studentService.getDepartmentByStudentId(id), HttpStatus.OK);
    }
    @DeleteMapping("/year/{yearOfEnrollment}")
    public ResponseEntity<String> deleteStudentsByYearOfEnrollment(@PathVariable("yearOfEnrollment") String yearOfEnrollment) {
        studentService.deleteStudentsByYearOfEnrollment(yearOfEnrollment);
        return new ResponseEntity<String>("Students Deleted Successfully", HttpStatus.OK);
    }


}

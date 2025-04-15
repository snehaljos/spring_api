package com.an.api.controller;


import com.an.api.Exception.UserNotFoundException;
import com.an.api.model.Student;
import com.an.api.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/AllStudents")
    public List<Student> getAllStudent(){
        return studentService.list();
    }


    @GetMapping("/StudentById/{student_id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long student_id) {
        logger.info("Received request to get student By id");
        Optional<Student> student = studentService.getStudentById(student_id);
        logger.info("Student with id {}",student_id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/Student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        logger.info("Received request to add student");
        Student student1 = studentService.addStudent(student);
        logger.info("Student added with id {}",student1.getStudent_id());
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    @DeleteMapping("/StudentById/{student_id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long student_id){
        logger.info("Received request to delete student with id {}", student_id);
        studentService.deleteStudent(student_id);
        logger.info("Student deleted with id {}", student_id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/StudentById/{student_id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long student_id, @RequestBody Student updatedstudent){
        logger.info("Received request to Update student with id {}", student_id);
        Student student= studentService.updateStudent(student_id,updatedstudent);
        logger.info("Student Updated with id {}", student_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}


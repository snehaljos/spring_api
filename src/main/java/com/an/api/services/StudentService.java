package com.an.api.services;


import com.an.api.Exception.UserNotFoundException;
import com.an.api.model.Student;
import com.an.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;


    public List<Student> list(){
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long student_id){
        Optional<Student> student = studentRepo.findById(student_id);
        if(student.isEmpty()){
            throw new UserNotFoundException("Student not present with id "+ student_id);
        }
        return student;
    }

    public Student addStudent(Student student) {
        return  studentRepo.save(student);
    }

    public void deleteStudent(Long student_id) {
         studentRepo.deleteById(student_id);
    }

    public Student updateStudent(Long student_id, Student updatedstudent) {
        Optional<Student> studentOptional = studentRepo.findById(student_id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirst_name(updatedstudent.getFirst_name());
            student.setLast_name(updatedstudent.getLast_name());
            student.setEmail(updatedstudent.getEmail());
            student.setEnrollment_date(updatedstudent.getEnrollment_date());
            student.setDate_of_birth(updatedstudent.getDate_of_birth());
            return studentRepo.save(student);
        } else {
            throw new UserNotFoundException("Student not found with id " + student_id);
        }


    }
}

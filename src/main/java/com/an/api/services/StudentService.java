package com.an.api.services;


import com.an.api.model.Student;
import com.an.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;


    public List<Student> list(){
        return studentRepo.findAll();
    }


}

package com.an.api.controller;


import com.an.api.model.Student;
import com.an.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private StudentService studenSer;

    @GetMapping
    @RequestMapping("/")
    public List<Student> getAllStudent(){
        return studenSer.list();
    }
}

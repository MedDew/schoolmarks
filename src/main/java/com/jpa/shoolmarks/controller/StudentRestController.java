package com.jpa.shoolmarks.controller;

import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, path = "/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudentList();
    }

    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable(name = "id") long studentId){
        return studentService.getStudentById(studentId);
    }




}

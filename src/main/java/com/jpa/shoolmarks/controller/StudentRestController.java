package com.jpa.shoolmarks.controller;

import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, path = "/students")
    public List<StudentDTO> getStudents(){
        return studentService.getStudentList();
    }
}

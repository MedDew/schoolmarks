package com.jpa.shoolmarks.controller;

import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/students/name")// /{studentName}
    public StudentDTO getStudent(@RequestParam(name = "studentName") String name){
        try {
            return studentService.getStudentByName(name);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with name : "+name+" not found", e);
        }
    }
}

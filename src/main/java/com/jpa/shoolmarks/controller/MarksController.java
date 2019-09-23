package com.jpa.shoolmarks.controller;

import com.jpa.shoolmarks.dto.MarksDTO;
import com.jpa.shoolmarks.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarksController {
    @Autowired
    private MarkService markService;

    @RequestMapping(method = RequestMethod.GET, path = "/students/mark")
    public List<MarksDTO> getMarksForStudent(){
        return markService.getStudentMarks();
    }

    @GetMapping(path = "/students/mark2")
    public List<MarksDTO> getMarksForStudent2(){
        return markService.getStudentMarks2();
    }
}

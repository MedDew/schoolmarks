package com.jpa.shoolmarks.service;

import com.jpa.shoolmarks.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getStudentList();
    StudentDTO getStudentById(long id);
    StudentDTO getStudentByName(String name);
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(long id, StudentDTO studentDTO);
    StudentDTO deleteteStudent(long id);
}

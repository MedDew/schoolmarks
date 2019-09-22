package com.jpa.shoolmarks.service;

import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.entity.Student;
import com.jpa.shoolmarks.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getStudentList() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentRepository.findAll().forEach(s -> {
            StudentDTO student = new StudentDTO(s.getId(),s.getName(), s.getAge());
            studentDTOList.add(student);
        });
        return studentDTOList;
    }

    @Override
    public StudentDTO getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        //if(student.isPresent()) {
            StudentDTO studentDTOById = new StudentDTO(student.get().getId(), student.get().getName(), student.get().getAge());
        //}
        return studentDTOById;
    }

    @Override
    public StudentDTO getStudentByName(String name) {
        Student student = studentRepository.getStudentByName(name);
        StudentDTO studentDTOByName = new StudentDTO(student.getId(), student.getName(), student.getAge());
        return studentDTOByName;
    }

    @Override
    public StudentDTO createStudent() {
        return null;
    }

    @Override
    public StudentDTO updateStudent() {
        return null;
    }

    @Override
    public StudentDTO deleteteStudent() {
        return null;
    }
}

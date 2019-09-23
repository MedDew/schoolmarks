package com.jpa.shoolmarks.service;

import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.entity.Student;
import com.jpa.shoolmarks.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());

        Student studentCreated  = studentRepository.save(student);
        StudentDTO studentDTOCreated = new StudentDTO(studentCreated.getId(), studentCreated.getName(), studentCreated.getAge());

        return studentDTOCreated;
    }

    @Override
    public StudentDTO updateStudent(long id, StudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student studentToUpdate = student.get();
            studentToUpdate.setId(studentDTO.getId());
            studentToUpdate.setName(studentDTO.getName());
            studentToUpdate.setAge(studentDTO.getAge());
            Student studentUpdated = studentRepository.save(studentToUpdate);
            StudentDTO studentDTOUpdated = new StudentDTO(studentUpdated.getId(), studentUpdated.getName(), studentUpdated.getAge());

            return studentDTOUpdated;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The student with id : "+ id +" to update does not exist");
        }

    }

    @Override
    public StudentDTO deleteteStudent(long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if(foundStudent.isPresent()){
            Student studentToDelete = foundStudent.get();
            studentRepository.delete(studentToDelete);
            StudentDTO studentDTODeleted = new StudentDTO(studentToDelete.getId(), studentToDelete.getName(), studentToDelete.getAge());
            return studentDTODeleted;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The student to delete with id : "+id+" does not exist");
        }
    }
}

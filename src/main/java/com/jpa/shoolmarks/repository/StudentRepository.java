package com.jpa.shoolmarks.repository;

import com.jpa.shoolmarks.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student getStudentByName(String name);
}
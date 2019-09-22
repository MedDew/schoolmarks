package com.jpa.shoolmarks.repository;

import com.jpa.shoolmarks.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    //@Query("Select s From Student s Where s.name = :name")//CANNOT HANDLE LIMIT WITH JPQL AND @Query
    @Query(value = "SELECT * FROM Student s Where s.name = :name LIMIT 1", nativeQuery = true)
    Student getStudentByName(@Param("name") String studentName);
}
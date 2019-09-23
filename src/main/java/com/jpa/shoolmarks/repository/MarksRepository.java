package com.jpa.shoolmarks.repository;

import com.jpa.shoolmarks.dto.MarksDTO;
import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.entity.Marks;
import com.jpa.shoolmarks.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarksRepository extends CrudRepository<Marks, Long> {
    @Query(value = "SELECT m.id, s.id, s.name, s.age , m.student_id, m.marks, m.year  " +
            "FROM Student s INNER JOIN Marks m ON s.id = m.student_id", nativeQuery = true)
    List<Marks> getStudentMarks();

    @Query(value = "Select new com.jpa.shoolmarks.dto.MarksDTO(m.id, m.student.id, m.marks, m.year, s.name, s.age)  " +
            "From Marks m INNER JOIN m.student s")
    //@Query(value = "Select m From Marks m") // SAME RESULT AS THE ABOVE WITH THE Marks Entity instead
//    List<Marks> getStudentMarks2();
    List<MarksDTO> getStudentMarks2();
}

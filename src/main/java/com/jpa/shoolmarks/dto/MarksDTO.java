package com.jpa.shoolmarks.dto;

import com.jpa.shoolmarks.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MarksDTO {
    private long id;
    private long studentId;
    private int marks;
    private int year;
    private String studentName;
    private int studentAge;
}

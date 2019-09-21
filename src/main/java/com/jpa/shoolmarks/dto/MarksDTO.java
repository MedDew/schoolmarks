package com.jpa.shoolmarks.dto;

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
}

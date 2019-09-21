package com.jpa.shoolmarks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int age;
}

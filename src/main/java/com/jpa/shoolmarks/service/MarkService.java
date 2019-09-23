package com.jpa.shoolmarks.service;

import com.jpa.shoolmarks.dto.MarksDTO;
import com.jpa.shoolmarks.dto.StudentDTO;

import java.util.List;

public interface MarkService {
    List<MarksDTO> getStudentMarks();

    List<MarksDTO> getStudentMarks2();
}

package com.jpa.shoolmarks.service;

import com.jpa.shoolmarks.dto.MarksDTO;
import com.jpa.shoolmarks.dto.StudentDTO;
import com.jpa.shoolmarks.entity.Marks;
import com.jpa.shoolmarks.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public List<MarksDTO> getStudentMarks() {
        List<MarksDTO> marksDTOList = new ArrayList<>();
        marksRepository.getStudentMarks().forEach(m -> {
            System.out.println(m.getId()+" ==> "+m.getStudent().getId()+" ==> "+m.getMarks()+" ==> "+m.getYear()+ " ==> "+m.getStudent().getName());
            StudentDTO studentDTO = new StudentDTO(m.getStudent().getId(), m.getStudent().getName(), m.getStudent().getAge());

            MarksDTO marksDTO = new MarksDTO(m.getId(),m.getStudent().getId(), m.getMarks(), m.getYear(), studentDTO.getName(), studentDTO.getAge());
            marksDTOList.add(marksDTO);
        });
        return marksDTOList;
    }

    @Override
    public List<MarksDTO> getStudentMarks2() {
        //
        /*List<Marks> marksList = marksRepository.getStudentMarks2();
        List<MarksDTO> marksDTOList = new ArrayList<>();
        marksList.forEach(m -> {
            MarksDTO marksDTO = new MarksDTO(m.getId(), m.getStudent().getId(), m.getMarks(), m.getYear(), m.getStudent().getName(), m.getStudent().getAge());
            marksDTOList.add(marksDTO);
        });
        return marksDTOList;*/
        return marksRepository.getStudentMarks2();
    }
}

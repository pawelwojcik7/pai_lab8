package com.pai.lab8.services;

import com.pai.lab8.converters.StudentConverter;
import com.pai.lab8.converters.StudentMapper;
import com.pai.lab8.dto.StudentDTO;
import com.pai.lab8.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter studentConverter;

    private final StudentMapper studentMapper;
    public List<StudentDTO> getAllStudents() {

        return studentRepository
                .findAll()
                .stream()
                .map(studentConverter::convert)
                .collect(Collectors.toList());
    }
    public List<StudentDTO> getAllStudentsNoAttachments() {

        return studentRepository.findAllNoAttachment();
    }

    public List<StudentDTO> getAllStudentsByMapper(){
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::mapStudentToStudentDTO)
                .collect(Collectors.toList());
    }

}

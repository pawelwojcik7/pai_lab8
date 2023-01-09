package com.pai.lab8.converters;


import com.pai.lab8.domain.Student;
import com.pai.lab8.dto.StudentDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements Converter<Student, StudentDTO> {
    @Override
    public StudentDTO convert(Student student) {
        return StudentDTO.builder()
                .name(student.getName())
                .surname(student.getSurname())
                .age(student.getAge())
                .street(student.getAddress().getStreet())
                .city(student.getAddress().getCity())
                .zip(student.getAddress().getZip())
                .state(student.getAddress().getState())
                .build();
    }


}

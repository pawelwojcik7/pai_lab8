package com.pai.lab8.repositories;

import com.pai.lab8.domain.Student;
import com.pai.lab8.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("select new com.pai.lab8.dto.StudentDTO(s.name, s.surname, s.age, s.address.street, s.address.city, s.address.zip, s.address.state) from Student s")
    List<StudentDTO> findAllNoAttachment();


}

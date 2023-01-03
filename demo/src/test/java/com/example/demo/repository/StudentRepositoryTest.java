package com.example.demo.repository;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveData() {
        students s = students.builder()
                .emailId("sleemraja@33")
                .firstName("saleem")
                .LastName("raja")
                .build();

        studentRepository.save(s);
    }

    @Test
    public void saveDataWIthEmbeddedGuardian() {
        Guardian guardian = Guardian.builder()
                .Email("meenas@selva")
                .Name("qwe")
                .Mobile("4747474747").build();
        students s = students.builder()
                .emailId("salemajftdfa@!23526")
                .guardian(guardian)
                .build();
        studentRepository.save(s);

    }

    @Test
    public void findTheNameOfEmail() {
        List<students> s = studentRepository.findByEmailId("salemaja@!233");
        System.out.println(s);
    }

    @Test
    public void findNameContaining() {
        List<students> s = studentRepository.findByFirstNameContaining("s");
        System.out.println(s);
    }

    @Test
    public void findFirstNameIsNull() {
        List<students> s = studentRepository.findByFirstNameNull();
        System.out.println(s);
    }
    @Test
    public void findByGuardian(){

        List<students > s= studentRepository.findByGuardianName("qwe");
        System.out.println(s);

    }
}

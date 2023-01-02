package com.example.demo.repository;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveData() {
        students s = students.builder()
                .emailId("saleemraja@!22233")
                .firstName("saleem")
                .LastName("raja")
                .build();

        studentRepository.save(s);
    }

    @Test
    public void saveDataWIthEmbeddedGuardian(){
        Guardian guardian=Guardian.builder()
                .Email("meenas@selva")
                .Name("qwe")
                .Mobile("4747474747").build();
        students s = students.builder()
                .emailId("saleemaja@!233")
                .firstName("saleem")
                .LastName("raja")
                .guardian(guardian)
                .build();
        studentRepository.save(s);

    }
}
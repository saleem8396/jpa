package com.example.demo.repository;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Students;
import com.example.demo.entity.Students;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void saveData() {
//        students s = students.builder()
//                .emailId("sleemraja@33")
//                .firstName("saleem")
//                .lastName("raja")
//                .build();
//
//        studentRepository.save(s);
//    }

    @Test
    public void saveDataWIthEmbeddedGuardian() {
        Guardian guardian = Guardian.builder()
                .email("meenas@selva")
                .name("qwe")
                .code("12354")
                .mobile("4747474747").build();
        Students s = Students.builder()
                .emailId("sameena213100")
                .guardian(guardian)
                .build();
        studentRepository.save(s);

    }

    @Test
    public void findTheNameOfEmail() {
        List<Students> s = studentRepository.findByEmailId("sameena213100");
        System.out.println(s);
    }

    @Test
    public void findNameContaining() {
        List<Students> s = studentRepository.findByFirstNameContaining("s");
        System.out.println(s);
    }

    @Test
    public void findFirstNameIsNull() {
        List<Students> s = studentRepository.findByFirstNameNull();
        System.out.println(s);
    }
//    @Test
//    public void findByGuardian(){
//
//        List<students > s= studentRepository.findByGuardianName("qwe");
//        System.out.println(s);
//
//    }
//
//    @Test
//    public void findByQuery(){
//
//        students s= studentRepository.getByGaurdianCode("123");
//        System.out.println(s);
//    }

    @Test
    public void getStudentsEmail(){
        Students s = studentRepository.getStudentsEmail("sameena213100");
        System.out.println(s);

    }
    @Test
    public void getGuardianCode(){
        Students s = studentRepository.getGuardianCode("123");
        System.out.println(s);

    }

    @Test
    public void changeGuardianName(){
        studentRepository.changeGuardianName("meena","123");


    }


}

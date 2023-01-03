package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveData() {

        Course course = Course.builder()
                .title("Spring")
                .credit(10)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.yahoo.com")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void findData(){
        Optional<CourseMaterial> c=courseMaterialRepository.findById(3L);
        System.out.println(c.get());
    }
    @Test
    public void findAllData(){

        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println("course material " + courseMaterials);
    }
}
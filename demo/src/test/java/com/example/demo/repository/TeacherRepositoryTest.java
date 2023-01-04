package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("Data base")
                .credit(9).build();
        Teacher teacher = Teacher.builder()
//                .courseList(List.of(course))
                .firstName("selva")
                .lastName("meenakshi").build();

        teacherRepository.save(teacher);
    }


}
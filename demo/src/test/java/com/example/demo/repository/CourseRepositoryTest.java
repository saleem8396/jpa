package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findDataByCourse(){
        List<Course> c =courseRepository.findAll();
        System.out.println("course and courseMaterial " + c);
    }

    @Test
    public void insertDataIntoCourseAndTeacher(){

        Teacher teacher =Teacher.builder()
                .lastName("raja")
                .firstName("sameensa").build();
        Course course= Course.builder()
                .credit(6)
                .title("teredata")
                .teacher(teacher).build();
        courseRepository.save(course);
    }
    @Test
    public void findByPages(){

    Pageable pageWithThreeRecords = PageRequest.of(0,2);

    List<Course> courseList=  courseRepository.findAll(pageWithThreeRecords).getContent();
        System.out.println(" page"+ courseList.get(0));
    }

    @Test
    public void findByPageAndSort(){

        Pageable pageWithThreeRecords = PageRequest.of(0,2, Sort.by("title"));
        Pageable pageWithThreeRecordsSortByCredit = PageRequest.of(0,2, Sort.by("credit").descending());

        List<Course> c =courseRepository.findAll(pageWithThreeRecords).getContent();
        List<Course> v =courseRepository.findAll(pageWithThreeRecordsSortByCredit).getContent();

        for(Course course : c){

            System.out.println(course);
        }

        for(Course course : v){

            System.out.println(course);
        }


    }
}
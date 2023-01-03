package com.example.demo.repository;

import com.example.demo.entity.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<students,Long> {

    List<students> findByEmailId(String email);

    List<students> findByFirstNameContaining(String name);

    List<students> findByFirstNameNull();
    List<students> findBylastNameNull();

    List<students>findByGuardianName(String name);
}

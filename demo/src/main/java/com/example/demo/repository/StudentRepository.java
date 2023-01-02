package com.example.demo.repository;

import com.example.demo.entity.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<students,Long> {
}
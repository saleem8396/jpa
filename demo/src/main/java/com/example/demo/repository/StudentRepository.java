package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {

    List<Students> findByEmailId(String email);

    List<Students> findByFirstNameContaining(String name);

    List<Students> findByFirstNameNull();
//    List<students> findBylastNameNull();
//
//    List<students>findByGuardianName(String name);
//
//    @Query("select s from Guardian s where s.code =?1")
//    students getByGaurdianCode(String code);

    @Query("select s from Students s where s.emailId = :email")
    Students getStudentsEmail(@Param("email") String email);

    @Query("select c from Students c where c.guardian.code = ?1")
    Students getGuardianCode(String code);
}

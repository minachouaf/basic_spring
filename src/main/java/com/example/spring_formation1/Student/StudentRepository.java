package com.example.spring_formation1.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT S FROM Student S where S.email=?1")
    Optional<Student> findStudentByEmail(String email);
}

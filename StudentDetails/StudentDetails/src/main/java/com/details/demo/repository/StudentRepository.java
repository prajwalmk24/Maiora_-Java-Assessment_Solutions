package com.details.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.details.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAgeBetween(int minAge, int maxAge);

}

package com.example.std_backend.repository;

import com.example.std_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Long> {
//    Student findAllById(Long studentId);
}

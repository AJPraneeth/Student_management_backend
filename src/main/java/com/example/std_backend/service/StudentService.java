package com.example.std_backend.service;

import com.example.std_backend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentId,StudentDto updateStudent);

    void deleteStudent(Long studentId);

}

package com.example.std_backend.mapper;

import com.example.std_backend.dto.StudentDto;
import com.example.std_backend.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        if (student == null) {
            return null;
        }
        return new StudentDto(
            student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        if (studentDto == null ) {
            return null;
        }
        return new Student(
//                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()

        );
    }
}

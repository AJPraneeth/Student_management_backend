package com.example.std_backend.service.impl;

import com.example.std_backend.dto.StudentDto;
import com.example.std_backend.entity.Student;
import com.example.std_backend.exception.ResourceNotFoundException;
import com.example.std_backend.mapper.StudentMapper;
import com.example.std_backend.repository.StudentRepository;
import com.example.std_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= StudentMapper.mapToStudent(studentDto);

        if (student == null) {
            return null;
        }
        Student savedStudent;
        savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student= studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException(
                "Student is not exists with given id :"+studentId
        ));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students=studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateStudent) {

        Student student= studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException(
                "Student is not exists with given id :"+studentId
        ));

        student.setFirstname(updateStudent.getFirstName());
        student.setLastname(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());

        Student updateStudentObj=studentRepository.save(student);
            return StudentMapper.mapToStudentDto(updateStudentObj);


    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student= studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException(
                "Student is not exists with given id :"+studentId
        ));

        studentRepository.deleteById(studentId);
    }
}

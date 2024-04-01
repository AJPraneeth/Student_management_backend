package com.example.std_backend.controller;

import com.example.std_backend.dto.StudentDto;
import com.example.std_backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/student")
public class studentController {
    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //add Student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent=studentService.createStudent(studentDto);
        return  new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //get All
@GetMapping
    public  ResponseEntity<List<StudentDto>>getAllStudent(){
        List<StudentDto> students=studentService.getAllStudent();
        return ResponseEntity.ok(students);
}

//get by Id
    @GetMapping("{id}")
    public  ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto=studentService.getStudentById(studentId);
        return  ResponseEntity.ok(studentDto);
    }
//update student
@PutMapping ("{id}")
    public ResponseEntity<StudentDto>updateStudent(@PathVariable("id") Long studentId,
                                                   @RequestBody StudentDto updateStudent){
        StudentDto studentDto=studentService.updateStudent(studentId,updateStudent);
        return  ResponseEntity.ok(studentDto);
    }
    //Deletestudent
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return  ResponseEntity.ok("Student Deleted Successfully");
    }

}

package com.example.std_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email_id", unique = true)
    private String email;

    public Student() {
    }

    // Constructor with all fields
    public Student(String firstName, String lastName, String email) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
    }

}


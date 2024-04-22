package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Teacher mentor;

    private LocalDate dob;

    // Getters and setters

    public Student() {}

    public Student(String firstName, String lastName, String email, Teacher mentor, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mentor = mentor;
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher getMentor() {
        return mentor;
    }

    public void setMentor(Teacher mentor) {
        this.mentor = mentor;
    }

}

package com.mees.SchoolManager.Student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String password;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Teacher mentor;

    private LocalDate dob;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<SchoolClass> SchoolClasses;

    public Student() {
    }

    public Student(String firstName, String lastName, String password, String email, Teacher mentor, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mentor = mentor;
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<SchoolClass> getSchoolClasses() {
        if (SchoolClasses == null) {
            SchoolClasses = new HashSet<>();
        }
        return SchoolClasses;
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName;
    }
}
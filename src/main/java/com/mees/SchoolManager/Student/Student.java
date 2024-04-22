package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;


@Entity
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

    // Getters and setters
    public Student(String firstName, String lastName, String email, Teacher mentor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mentor = mentor;
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

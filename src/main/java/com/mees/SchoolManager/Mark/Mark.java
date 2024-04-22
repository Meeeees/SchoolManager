package com.mees.SchoolManager.Mark;

import com.mees.SchoolManager.Student.Student;
import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;

public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float mark;

    @ManyToMany
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    @JoinColumn(name = "student_id")
    private Student student;

    public Mark(Float mark, Teacher teacher, Student student) {
        this.mark = mark;
        this.teacher = teacher;
        this.student = student;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    // Getters and setters
}
package com.mees.SchoolManager.Mark;

import com.mees.SchoolManager.Mark.Mark;
import com.mees.SchoolManager.Student.Student;
import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.ZoneId;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate markEntry = LocalDate.now();

    private Float mark;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Student student;

    public Mark() {};
    public Mark(Float mark, Teacher teacher, Student student, String name) {
        this.mark = mark;
        this.teacher = teacher;
        this.student = student;
        this.name = name;
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

    public Student getStudent() {
        return student;
    }

    public LocalDate getMarkEntry() {
        return markEntry;
    }

    public void setMarkEntry(LocalDate markEntry) {
        this.markEntry = markEntry;
    }

    public String getName() {
        return name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setName(String name) {
        this.name = name;
    }

}

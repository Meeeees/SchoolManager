package com.mees.SchoolManager.ClassStudent;

import com.mees.SchoolManager.Student.Student;
import com.mees.SchoolManager.Class.Class;
import jakarta.persistence.*;


@Entity
@Table(name = "class_student")
public class ClassStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    public ClassStudent(Student student, Class clazz) {
        this.student = student;
        this.clazz = clazz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}

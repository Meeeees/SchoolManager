package com.mees.SchoolManager.SchoolClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.Student.Student;
import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SchoolClass")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String room;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private Date beginTime;
    private Date endTime;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "SchoolClass_Student",
                joinColumns = @JoinColumn(name = "SchoolClass_id"),
                inverseJoinColumns = @JoinColumn(name = "Student_id"))
    private Set<Student> students;

    public SchoolClass(String name, String room, Teacher teacher, Date beginTime, Date endTime) {
        this.name = name;
        this.room = room;
        this.teacher = teacher;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public void addStudents(Student student) {
        if (students == null) {
            students = new HashSet<>();
        }
        students.add(student);
        student.getSchoolClasses().add(this);
    }

    public SchoolClass() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void removeStudent(Student student) {
        if (students != null) {
            students.remove(student);
            student.getSchoolClasses().remove(this);
        }
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Room: ").append(room).append("\n");
        sb.append("Teacher: ").append(teacher.getFirstName()).append(teacher.getLastName()).append("\n");
        sb.append("Begin Time: ").append(beginTime).append("\n");
        sb.append("End Time: ").append(endTime).append("\n");
        for (Student student : students) {
            sb.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
        return sb.toString();
    }

}
package com.mees.SchoolManager.Class;

import com.mees.SchoolManager.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String room;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private Date date;
    private Date beginTime;
    private Date endTime;

    public Class(String name, String room, Teacher teacher, Date date, Date beginTime, Date endTime) {
        this.name = name;
        this.room = room;
        this.teacher = teacher;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
package com.mees.SchoolManager.Teacher;

import com.mees.SchoolManager.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository TeacherRepository;

    public List<Teacher> getAllTeachers() {
        return TeacherRepository.findAll();
    }
}

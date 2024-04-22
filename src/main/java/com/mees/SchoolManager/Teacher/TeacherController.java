package com.mees.SchoolManager.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Teachers")
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return TeacherService.getAllTeachers();
    }
}
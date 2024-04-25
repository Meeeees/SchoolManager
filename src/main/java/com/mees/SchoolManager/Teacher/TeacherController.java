package com.mees.SchoolManager.Teacher;

import com.mees.SchoolManager.Student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id) {
        return TeacherService.getTeacher(id);
    }

    @PostMapping
    public void AddStudent(@RequestBody Teacher teacher) {
        TeacherService.addTeacher(teacher);
    }


    @Transactional
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") int studentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String topic) {
        TeacherService.updateTeacher(studentId, firstName, lastName, password, email, topic);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteStudent(@PathVariable("teacherId") int teacherId) {
        TeacherService.deleteTeacher(teacherId);
    }

}
package com.mees.SchoolManager.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public void AddStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @Transactional
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") int studentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer mentor_id) {
        studentService.updateStudent(studentId, firstName, lastName, password, email, mentor_id);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
    }

}
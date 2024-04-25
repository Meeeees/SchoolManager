package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.SchoolClass.SchoolClassRepository;
import com.mees.SchoolManager.Teacher.Teacher;
import com.mees.SchoolManager.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) throw new IllegalStateException("Student with that email already exists");

        studentRepository.save(student);
    }

    public Optional<Student> getStudent(int id) {
        if (!studentRepository.existsById(id)) throw new IllegalStateException("Student with that id doesn't exist");

        return studentRepository.findById(id);
    }

    public void updateStudent(int studentId, String firstName, String lastName, String password, String email, Integer mentorId) {
        if (!studentRepository.existsById(studentId)) throw new IllegalStateException("Student with that id doesn't exist");

        Optional<Student> OptionalStudent = studentRepository.findById(studentId);
        Student student = OptionalStudent.get();

        if (firstName != null) {
            student.setFirstName(firstName);
        }
        if (lastName != null) {
            student.setLastName(lastName);
        }
        if (password != null) {
            student.setPassword(password);
        }
        if (email != null) {
            student.setEmail(email);
        }
        if (mentorId != null && teacherRepository.existsById(mentorId)) {
            Teacher newMentor = teacherRepository.findById(mentorId).get();
            student.setMentor(newMentor);
        }
    }

    public void deleteStudent(int studentId) {
        Optional<Student> potentialStudent = studentRepository.findById(studentId);
        if (potentialStudent.isEmpty()) throw new IllegalStateException("Student with that id doesn't exist");
        Student student = potentialStudent.get();
        Set<SchoolClass> SchoolClassesSet = student.getSchoolClasses();
        List<SchoolClass> SchoolClasses = new ArrayList<>(SchoolClassesSet);
        if (!SchoolClasses.isEmpty()) {
            for (SchoolClass aSchoolClass : SchoolClasses) {
                System.out.println("SchoolClassES: " + aSchoolClass);
                aSchoolClass.removeStudent(student);
            }
        }

        studentRepository.deleteById(studentId);
    }
}

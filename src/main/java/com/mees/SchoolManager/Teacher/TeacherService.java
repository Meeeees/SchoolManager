package com.mees.SchoolManager.Teacher;

import com.mees.SchoolManager.Mark.Mark;
import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository TeacherRepository;

    public List<Teacher> getAllTeachers() {
        return TeacherRepository.findAll();
    }

    public Teacher getTeacher(int id) {
        if (!TeacherRepository.existsById(id)) throw new IllegalStateException("Teacher with that id does not exist");
        return TeacherRepository.findById(id).get();
    }

    public void addTeacher(Teacher teacher) {
        TeacherRepository.save(teacher);
    }

    public void updateTeacher(int teacherId, String firstName, String lastName, String password, String email, String topic) {
        Optional<Teacher> OptionalStudent = TeacherRepository.findById(teacherId);
        if (OptionalStudent.isEmpty()) throw new IllegalStateException("Teacher with that id doesnt exist");

        Teacher teacher = OptionalStudent.get();

        if (firstName != null) {
            teacher.setFirstName(firstName);
        }
        if (lastName != null) {
            teacher.setLastName(lastName);
        }
        if (password != null) {
            teacher.setPassword(password);
        }
        if (email != null) {
            teacher.setEmail(email);
        }
        if (topic != null) {
            teacher.setTopic(topic);
        }
    }

    public void deleteTeacher(int teacherId) {
        List<SchoolClass> classes = TeacherRepository.getClassesOfTeacher(teacherId);
        List<Student> students = TeacherRepository.getStudentsOfTeacher(teacherId);
        List<Mark> marks = TeacherRepository.getMarksOfTeacher(teacherId);

        if (!classes.isEmpty()) {
            for (SchoolClass aClass : classes) {
                aClass.setTeacher(null);
            }
        }
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.setMentor(null);
            }
        }   if (!marks.isEmpty()) {
            for (Mark mark : marks) {
                mark.setTeacher(null);
            }
        }
        TeacherRepository.deleteById(teacherId);
    }
}

package com.mees.SchoolManager.Teacher;

import com.mees.SchoolManager.Mark.Mark;
import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.Student.Student;
import com.mees.SchoolManager.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT c FROM SchoolClass c WHERE c.teacher.id = :mentorId")
    List<SchoolClass> getClassesOfTeacher(@Param("mentorId") Integer mentorId);

    @Query("SELECT c FROM Student c WHERE c.mentor.id = :mentorId")
    List<Student> getStudentsOfTeacher(@Param("mentorId") Integer mentorId);

    @Query("SELECT c FROM Mark c WHERE c.teacher.id = :mentorId")
    List<Mark> getMarksOfTeacher(@Param("mentorId") Integer mentorId);
}

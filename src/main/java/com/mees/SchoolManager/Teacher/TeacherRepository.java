package com.mees.SchoolManager.Teacher;

import com.mees.SchoolManager.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

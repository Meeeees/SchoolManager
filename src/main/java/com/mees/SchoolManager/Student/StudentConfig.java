package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.Teacher.Teacher;
import com.mees.SchoolManager.Teacher.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        return args -> {
            Teacher teacher = new Teacher("Sjoerd", "Nijsse", "Sjoerdnijsse@gmail.com", "sk");
            teacherRepository.save(teacher);
            Student mariam = new Student(
                    "Mariam",
                    "Dijkstra",
                    "Mariamdijkstra@mijheem.nl",
                    teacher,
                    LocalDate.of(2008, Month.JANUARY, 7)
            );
            studentRepository.save(mariam);
        };
    }
}

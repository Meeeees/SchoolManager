package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.SchoolClass.SchoolClass;
import com.mees.SchoolManager.SchoolClass.SchoolClassRepository;
import com.mees.SchoolManager.Mark.Mark;
import com.mees.SchoolManager.Mark.MarkRepository;
import com.mees.SchoolManager.Teacher.Teacher;
import com.mees.SchoolManager.Teacher.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, TeacherRepository teacherRepository, MarkRepository markRepository, SchoolClassRepository SchoolClassRepository) {
        return args -> {
            Teacher teacher = new Teacher("Sjoerd", "Nijsse", "Sjoerdje123", "Sjoerdnijsse@gmail.com", "sk");
            Teacher teacher2 = new Teacher("Danielle", "Hagg", "haggie", "DanielleHagg@gmail.com", "en");
            teacherRepository.save(teacher);
            teacherRepository.save(teacher2);
            Student mariam = new Student(
                    "Mariam",
                    "Dijkstra",
                    "Dijkstra123",
                    "Mariamdijkstra@mijheem.nl",
                    teacher,
                    LocalDate.of(2008, Month.JANUARY, 7)
            );
            Student henk = new Student(
                    "Henk",
                    "Roderik",
                    "Roder123",
                    "HenkRoderik@mijheem.nl",
                    teacher2,
                    LocalDate.of(2009, Month.JUNE, 29)
            );
            studentRepository.saveAll(List.of(mariam, henk));
            Mark scheik = new Mark(
                    8.9F,
                    teacher,
                    mariam,
                    "Organische chemie"
            );
            markRepository.save(scheik);

            SchoolClass scheikundeLes = new SchoolClass(
                    "Organische chemie",
                    "L204",
                    teacher,
                    Timestamp.valueOf("2024-04-25 09:00:00"),
                    Timestamp.valueOf("2024-04-25 10:10:00")
            );
            SchoolClass EngelsLes = new SchoolClass(
                    "Past, ping, pong engels",
                    "L039",
                    teacher2,
                    Timestamp.valueOf("2024-04-25 9:40:00"),
                    Timestamp.valueOf("2024-04-25 10:50:00")
            );
            scheikundeLes.addStudents(mariam);
            scheikundeLes.addStudents(henk);
            EngelsLes.addStudents(henk);
            SchoolClassRepository.save(EngelsLes);
            SchoolClassRepository.save(scheikundeLes);

        };
    }
}

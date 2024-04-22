package com.mees.SchoolManager.Student;

import com.mees.SchoolManager.Teacher.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "dijkstra",
                    "MariamDijkstra@mijheem.nl",
                    new Teacher("Sjoerd", "Nijsse", "SjoerdNijsse@heemlanden.nl", "Scheikunde"),
                    LocalDate.of(2008, Month.JANUARY, 7)
            );
            repository.saveAll(List.of(mariam));
        };
    }
}

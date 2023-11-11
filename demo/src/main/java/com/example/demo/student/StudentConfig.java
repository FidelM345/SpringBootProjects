package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration // this class is a source of bean definitions
public class StudentConfig {

    @Bean // the commandLineRunner interface tells spring to run this code immediately after application startup
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(1995, Month.APRIL, 5)
            );
            Student christopher = new Student(
                    "Christopher",
                    "christopher@gmail.com",
                    LocalDate.of(1993, Month.APRIL, 5)
            );
            repository.saveAll(List.of(mariam, christopher));
        };
    }
}

package com.example.spring_formation1.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            List<Student> studentList=new ArrayList<>();
            studentList.add(new Student(1L,"mina", LocalDate.of(2022, Month.JANUARY,18),"mina@gmail.com"));
            studentList.add(new Student(2L,"sara", LocalDate.of(2022, Month.JANUARY,18),"sara@gmail.com"));
            studentRepository.saveAll(studentList);

        };
    }
}

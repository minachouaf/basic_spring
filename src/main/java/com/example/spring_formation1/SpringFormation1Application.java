package com.example.spring_formation1;

import com.example.spring_formation1.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.MalformedObjectNameException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringFormation1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringFormation1Application.class, args);
    }


    //@GetMapping("/")
    //public List<String> returnhello() {
       // return List.of("hi","hello");
    //}


}

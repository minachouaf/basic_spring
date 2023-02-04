package com.example.spring_formation1.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student/")
public class StudentController {
    private  final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/")
    public List<Student> getStudents(){
       return studentService.getStudents();
    }
    @PostMapping("/register")
    public void registerStudent(@RequestBody Student student){
        studentService.register(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable Long id,@RequestParam String name,@RequestParam String email){
        studentService.updateStudent(id,name,email);
    }


    @GetMapping("/hi")
    public List<Student> returnhello() {
        return studentService.returnhello();
    }
}

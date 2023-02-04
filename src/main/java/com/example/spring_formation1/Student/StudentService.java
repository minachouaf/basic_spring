package com.example.spring_formation1.Student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> returnhello() {
        return List.of(new Student(1L,"mina", LocalDate.of(2022, Month.JANUARY,18),"mina@gmail.com"),
                new Student(1L,"sara",LocalDate.of(2022, Month.JANUARY,18),"sara@gmail.com"),
                new Student(1L,"kamal",LocalDate.of(2022, Month.JANUARY,18),"kamal@gmail.com"));
    }

    public void register(Student student) {
        Optional<Student> s=studentRepository.findStudentByEmail(student.getEmail());
        if(s.isPresent())
            throw new IllegalStateException("email taken");
        else
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
       boolean exist= studentRepository.existsById(id);
       if(!exist)
           throw new IllegalStateException("student with id "+id+" does not exist");
        studentRepository.deleteById(id);
    }

    @Transactional //set is transaction
    public void updateStudent(Long id, String name, String email) {
        Student s=studentRepository.findById(id).orElseThrow(()->
            new IllegalStateException("student with id "+id+"does not exist")
        );
        if(name!=null && name.length()>0 && !name.equals(s.getName()))
           s.setName(name);
        if(email!=null && email.length()>0 && !email.equals(s.getEmail()))
        {
            Optional<Student> student=studentRepository.findStudentByEmail(email);
            if (student.isPresent())
                throw new IllegalStateException("taken email "+email);
        }
        s.setEmail(email);
    }

}

package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//This tells spring that this class  is a bean - which means the class can be instantiated
@Service //serves same purpose as @component, but we have used it because it suggests meaning of how we are using this class
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("email is taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudentById(Long studentId) {
       boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with the id: "+studentId+" does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}

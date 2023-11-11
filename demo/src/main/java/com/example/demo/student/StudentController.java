package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This annotation makes this class to serve rest endpoints
@RequestMapping(path = "api/v1/student") //if not defined the api will use the default localhost base url
public class StudentController {

    private final StudentService studentService;

    @Autowired //tells spring that we want to magically pass the instance of the parameter class to our constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping//this annotation makes this method to act as a rest endpoint
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long id) {
        studentService.deleteStudentById(id);
    }
}

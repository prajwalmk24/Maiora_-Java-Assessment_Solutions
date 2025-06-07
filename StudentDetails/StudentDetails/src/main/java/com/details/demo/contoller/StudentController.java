package com.details.demo.contoller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.demo.model.Student;
import com.details.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Create
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // 2. Read
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 3. Calculate age and update
    @PutMapping("/{id}/calculate-age")
    public Student calculateAndUpdateAge(@PathVariable("id") Long id) {
        return studentService.calculateAndUpdateAge(id);
    }

    // 4. Get students between 18 and 25
    @GetMapping("/between")
    public List<Student> getStudentsBetween18and25() {
        return studentService.getStudentsBetweenAgeRange(18, 25);
    }
}


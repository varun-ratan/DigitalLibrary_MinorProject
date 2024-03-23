package com.digitalLibrary.springboot.controllers;

import com.digitalLibrary.springboot.dtos.CreateBookRequest;
import com.digitalLibrary.springboot.dtos.CreateStudentRequest;
import com.digitalLibrary.springboot.entities.Student;
import com.digitalLibrary.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("")
    public Student create(@RequestBody CreateStudentRequest createStudentRequest)
    {
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/get/{studentId}")
    public Student get(@PathVariable int studentId)
    {
        return studentService.get(studentId);
    }

    @DeleteMapping("/delete/{id}")
    public Student delete(@PathVariable int id)
    {
        return studentService.delete(id);
    }
}

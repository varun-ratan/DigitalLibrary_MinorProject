package com.digitalLibrary.springboot.services;

import com.digitalLibrary.springboot.dtos.CreateStudentRequest;
import com.digitalLibrary.springboot.entities.Student;
import com.digitalLibrary.springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create(CreateStudentRequest createStudentRequest)
    {
        Student student=createStudentRequest.to();
        return studentRepository.save(student);
    }

    public Student get(int  StudentId) {

        return studentRepository.findById(StudentId).orElse(null);
    }


    public Student delete( int  StudentId) {
        Student student = this.get(StudentId);
        studentRepository.delete(student);
        return student;
    }



}

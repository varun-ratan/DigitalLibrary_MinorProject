package com.digitalLibrary.springboot.repositories;

import com.digitalLibrary.springboot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}

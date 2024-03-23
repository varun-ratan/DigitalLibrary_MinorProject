package com.digitalLibrary.springboot.repositories;

import com.digitalLibrary.springboot.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(value="select a from Author a where a.email=?1")
    Author findByEmail(String email);
}

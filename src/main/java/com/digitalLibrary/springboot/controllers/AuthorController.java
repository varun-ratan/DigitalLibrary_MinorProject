package com.digitalLibrary.springboot.controllers;

import com.digitalLibrary.springboot.entities.Author;
import com.digitalLibrary.springboot.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/findAll")
    public List<Author> findAll()
    {
        return authorService.findAll();
    }


}

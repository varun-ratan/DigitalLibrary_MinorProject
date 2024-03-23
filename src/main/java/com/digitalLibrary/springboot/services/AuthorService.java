package com.digitalLibrary.springboot.services;

import com.digitalLibrary.springboot.entities.Author;
import com.digitalLibrary.springboot.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createOrGet(Author author)
    {
        Author authorFromDb=this.authorRepository.findByEmail(author.getEmail());
        if(authorFromDb!=null)
        {
            return authorFromDb;
        }

        return this.authorRepository.save(author);
    }

    public List<Author> findAll()
    {
        return authorRepository.findAll();
    }


}

package com.digitalLibrary.springboot.controllers;

import com.digitalLibrary.springboot.dtos.CreateBookRequest;
import com.digitalLibrary.springboot.dtos.SearchBookRequest;
import com.digitalLibrary.springboot.entities.Book;
import com.digitalLibrary.springboot.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/test")
    public String test() {
        return "Test API works!";
    }
    public List<Book> getBooks(@RequestBody SearchBookRequest searchBookRequest) throws Exception{
        return bookService.search(searchBookRequest);
    }
    @GetMapping("/search")
    public List<Book> search(@RequestParam String key,@RequestParam String value) throws Exception{
        return bookService.search(key,value);
    }

    /*
     *
     * URL: http://localhost:8080/book
     * Obj: {
    "name":"JBDL-65",
    "genre":"TECHNICAL",
    "pages":100,
    "authorName":"Aditya Dua",
    "authorCountry":"India",
    "authorEmail":"aditya@aditya.com"
}
     */
    @PostMapping("")
    public Book createBook(@RequestBody CreateBookRequest createBookRequest) {
        return bookService.create(createBookRequest);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.get();
    }

    //delete book by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id)
    {
        return bookService.deleteBook(id);
    }


}

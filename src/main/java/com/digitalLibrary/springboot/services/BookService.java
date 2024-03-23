package com.digitalLibrary.springboot.services;

import com.digitalLibrary.springboot.dtos.CreateBookRequest;
import com.digitalLibrary.springboot.dtos.SearchBookRequest;
import com.digitalLibrary.springboot.entities.Author;
import com.digitalLibrary.springboot.entities.Book;
import com.digitalLibrary.springboot.entities.Student;
import com.digitalLibrary.springboot.entities.enums.Genre;
import com.digitalLibrary.springboot.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Book create(CreateBookRequest createBookRequest) {
        Book book = createBookRequest.to();
        Author author = authorService.createOrGet(book.getMy_author());
        book.setMy_author(author);
        return bookRepository.save(book);
    }

    /*
     * I want search book by name
     * genre
     * id
     */

    public List<Book> search(SearchBookRequest searchBookRequest) throws Exception{
        boolean isValidRequest = searchBookRequest.validate();
        if(!isValidRequest) {
            throw new Exception("Invalid Request");
        }

        switch (searchBookRequest.getSearchKey()) {
            case "name":
                return bookRepository.findByName(searchBookRequest.getSearchValue());
            case "genre":
                return bookRepository.findByGenre(Genre.valueOf(searchBookRequest.getSearchValue()));
            case "id":
                Book book = bookRepository.findById(Integer.parseInt(searchBookRequest.getSearchValue())).orElse(null);
                return Arrays.asList(book);
            default:
                throw new Exception("invalid search key");
        }
    }

//    public List<Book> search( String key, String value) throws Exception{
//
//
//
//        switch (key) {
//            case "name":
//                return bookRepository.findByName(value);
//            case "genre":
//
//                return bookRepository.findByGenre(Genre.valueOf(value));
//            case "id":
//                //return new ArrayList<Book>().add(bookRepository.findById(Integer.valueOf(value)).get());
//        }
//        return null;
//    }

    public List<Book> get(){
        return bookRepository.findAll();
    }

    // create the logic to delete the books

    public ResponseEntity<String> deleteBook(int id)
    {
        int findId=bookRepository.findById(id).get().getId();
        if(findId==0)
        {
            return new ResponseEntity<>("Id is not present", HttpStatus.NOT_FOUND);
        }
        else {
            bookRepository.deleteById(findId);
        }

        return new ResponseEntity<>("Data is deleted for given id",HttpStatus.OK);
    }

        public void assignBookToStudent(Book book, Student student) {
    }

}

package com.digitalLibrary.springboot.controllers;

import com.digitalLibrary.springboot.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public String issue(@RequestParam("name") String name,@RequestParam("studentId") int studentId ) throws Exception {
        return transactionService.issueBook(name, studentId);
    }

    @PostMapping("/return")
    public String returnTxn(@RequestParam("bookId") int bookId,@RequestParam("studentId") int studentId ) throws Exception {
        return transactionService.returnTxn(bookId, studentId);
    }

}

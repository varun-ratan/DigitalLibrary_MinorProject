package com.digitalLibrary.springboot.repositories;

import com.digitalLibrary.springboot.entities.Book;
import com.digitalLibrary.springboot.entities.Student;
import com.digitalLibrary.springboot.entities.Transaction;
import com.digitalLibrary.springboot.entities.enums.TransactionStatus;
import com.digitalLibrary.springboot.entities.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByTransactionTimeDesc(
            Student student, Book book, TransactionType transactionType, TransactionStatus transactionStatus
    );
}

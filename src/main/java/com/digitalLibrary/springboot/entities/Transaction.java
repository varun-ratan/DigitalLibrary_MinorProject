package com.digitalLibrary.springboot.entities;

import com.digitalLibrary.springboot.entities.enums.TransactionStatus;
import com.digitalLibrary.springboot.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String externalTxnId;
    @CreationTimestamp
    private Date transactionTime;
    @UpdateTimestamp
    private Date updatedOn;

    private TransactionStatus transactionStatus;

    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn
    private Book my_book;
    @ManyToOne
    @JoinColumn
    private Student my_student;

    private Double fine;

}

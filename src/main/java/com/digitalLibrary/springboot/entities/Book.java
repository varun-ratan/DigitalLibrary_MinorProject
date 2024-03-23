package com.digitalLibrary.springboot.entities;

import com.digitalLibrary.springboot.entities.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(value= EnumType.STRING)
    private Genre genre;
    private int pages;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updateOn;
    @ManyToOne
    @JoinColumn
    private Author my_author;
    @ManyToOne
    @JoinColumn
    private Student my_student;
    @OneToMany(mappedBy = "my_book")
    private List<Transaction> transactionList;

}

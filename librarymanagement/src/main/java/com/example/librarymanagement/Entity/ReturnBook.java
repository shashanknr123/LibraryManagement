package com.example.librarymanagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "ReturnBook")
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="returnid")
    private int returnid;

    @Column(name="bookid")
    private int bookid;

    @Column(name="bookname")
    private String bookname;

    @Column(name="returnedNumber")
    private int returnedNumber;
}

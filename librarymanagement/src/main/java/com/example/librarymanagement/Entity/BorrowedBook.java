package com.example.librarymanagement.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Getter
@Setter
@Table(name = "BorrowedBook")
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="borrowid")
    private int borrowid;

    @Column(name="bookid")
    private int bookid;

    @Column(name="bookname")
    private String bookname;

    @Column(name="borrowedNumber")
    @ColumnDefault("0")
    private int borrowedNumber;

    @ManyToOne
    @JoinColumn(name = "library_bookid", referencedColumnName = "bookid", insertable = false, updatable = false)
    private Library library;
}

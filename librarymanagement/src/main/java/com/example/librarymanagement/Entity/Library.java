package com.example.librarymanagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Getter
@Setter
@Table(name = "Library")
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue
    @Column(name="bookid")
    private int bookid;

    @Column(name="bookname")
    private  String bookname;

    @Column(name="available")
    @ColumnDefault("0")
    private int available;


}

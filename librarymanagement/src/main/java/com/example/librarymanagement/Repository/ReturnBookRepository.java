package com.example.librarymanagement.Repository;

import com.example.librarymanagement.Entity.ReturnBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnBookRepository extends JpaRepository<ReturnBook, Integer> {
}
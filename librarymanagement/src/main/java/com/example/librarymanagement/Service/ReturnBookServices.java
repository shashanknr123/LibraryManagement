package com.example.librarymanagement.Service;

import com.example.librarymanagement.Entity.BorrowedBook;
import com.example.librarymanagement.Entity.Library;
import com.example.librarymanagement.Entity.ReturnBook;
import com.example.librarymanagement.Repository.BorrowedRepository;
import com.example.librarymanagement.Repository.LibraryRepository;
import com.example.librarymanagement.Repository.ReturnBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReturnBookServices {

    @Autowired
    private ReturnBookRepository returnBookRepository;

    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Transactional
    public ReturnBook returnBook(int bookid) {

        Library libraryBook = libraryRepository.findById(bookid)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        libraryBook.setAvailable(libraryBook.getAvailable() + 1);
        libraryRepository.save(libraryBook);

        ReturnBook returnBook = new ReturnBook();
        returnBook.setBookid(libraryBook.getBookid());
        returnBook.setBookname(libraryBook.getBookname());
        returnBook.setReturnedNumber(1);
        borrowedRepository.reduceBorrowedNumber(bookid);

        return returnBookRepository.save(returnBook);
    }
}
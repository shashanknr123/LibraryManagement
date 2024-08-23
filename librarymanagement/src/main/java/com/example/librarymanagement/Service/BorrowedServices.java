package com.example.librarymanagement.Service;

import com.example.librarymanagement.Entity.BorrowedBook;
import com.example.librarymanagement.Entity.Library;
import com.example.librarymanagement.Repository.BorrowedRepository;
import com.example.librarymanagement.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BorrowedServices {
    @Autowired
    private BorrowedRepository borrowedRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedRepository.findAllBorrow();
    }

    @Transactional
    public BorrowedBook saveBorrowedBook(int bookid) {


        Library libraryBook = libraryRepository.findById(bookid)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Check if the book is available
        if (libraryBook.getAvailable() > 0) {
            // Decrease the available book count by 1
            libraryBook.setAvailable(libraryBook.getAvailable() - 1);
            libraryRepository.save(libraryBook); // Update the library record

            // Create a new BorrowedBook entity
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setBookid(libraryBook.getBookid());
            borrowedBook.setBookname(libraryBook.getBookname());
            borrowedBook.setBorrowedNumber(1); // Assuming each entry represents one borrowed book

            // Save the borrowed book record
            return borrowedRepository.save(borrowedBook);
        } else {
            throw new RuntimeException("No copies available for borrowing");
        }
    }

}

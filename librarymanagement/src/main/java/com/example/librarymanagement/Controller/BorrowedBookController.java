package com.example.librarymanagement.Controller;
import com.example.librarymanagement.Entity.BorrowedBook;
import com.example.librarymanagement.Service.BorrowedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController

public class BorrowedBookController {

    @Autowired
    private BorrowedServices borrowedBookService;

    @PostMapping("/borrow/{bookid}")
    public BorrowedBook borrowBook(@PathVariable int bookid) {
        return borrowedBookService.saveBorrowedBook(bookid);
    }

    @GetMapping("/borrowedBooks")
    public List<BorrowedBook> getAllBorrowedBooks(){
        return borrowedBookService.getAllBorrowedBooks();
    }
}
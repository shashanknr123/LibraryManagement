package com.example.librarymanagement.Controller;

import com.example.librarymanagement.Entity.ReturnBook;
import com.example.librarymanagement.Service.ReturnBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ReturnBookController {

    @Autowired
    private ReturnBookServices returnBookService;

    @PostMapping("/return/{bookid}")
    public ReturnBook returnBook(@PathVariable int bookid) {
        return returnBookService.returnBook(bookid);
    }
}
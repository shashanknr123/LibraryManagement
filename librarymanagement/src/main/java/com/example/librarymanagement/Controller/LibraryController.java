package com.example.librarymanagement.Controller;

import com.example.librarymanagement.Entity.Library;
import com.example.librarymanagement.Service.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class LibraryController {
@Autowired
    private LibraryServices libraryServices;
@PostMapping("/addBook")
public Library addBookDetails(@RequestBody Library library){
        return libraryServices.addBook(library);
    }
    @GetMapping("/getBookDetails")
public List<Library> getBookDetails(){
    return libraryServices.getBook();
}

    @PutMapping("/update/{bookid}")
    public Library updateAvailableBooks(@PathVariable int bookid, @RequestBody Library library) {
        return libraryServices.updateAvailableBooks(bookid, library.getAvailable());
    }

}

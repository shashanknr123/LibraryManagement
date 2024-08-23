package com.example.librarymanagement.Service;

import com.example.librarymanagement.Entity.Library;
import com.example.librarymanagement.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServices {
    @Autowired
private LibraryRepository libraryRepository;

    public Library addBook(Library library){
        return libraryRepository.save(library);
    }
    public List<Library> getBook(){
        return libraryRepository.findAll();
    }
    public Library updateAvailableBooks(int bookid, int newAvailableBooks) {
        Library library = libraryRepository.findById(bookid).orElseThrow(() -> new RuntimeException("Book not found"));
        library.setAvailable(newAvailableBooks);
        return libraryRepository.save(library);
    }
}

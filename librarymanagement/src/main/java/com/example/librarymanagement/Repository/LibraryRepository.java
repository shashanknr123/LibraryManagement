package com.example.librarymanagement.Repository;

import com.example.librarymanagement.Entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Integer> {
}

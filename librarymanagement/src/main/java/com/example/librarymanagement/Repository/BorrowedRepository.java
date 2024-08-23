package com.example.librarymanagement.Repository;

import com.example.librarymanagement.Entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BorrowedRepository extends JpaRepository<BorrowedBook, Integer> {

    @Query(value = "select b from BorrowedBook b where b.borrowedNumber>0")
    List<BorrowedBook> findAllBorrow();
    @Modifying
    @Transactional
    @Query(value= "UPDATE BorrowedBook b SET b.borrowedNumber = b.borrowedNumber - 1 WHERE b.bookid = :bookid AND b.borrowedNumber > 0")
    void reduceBorrowedNumber(@Param("bookid") int bookid);

}

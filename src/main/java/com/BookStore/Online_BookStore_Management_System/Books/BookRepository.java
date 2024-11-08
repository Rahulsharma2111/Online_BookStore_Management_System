package com.BookStore.Online_BookStore_Management_System.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByTitle(String bookName);
    List<Book> findAllBookByCategory(String categoryName);
    List<Book> findAllBookByAuthor(String authorName);
//    Book findByTitle(String bookname);
}

package com.BookStore.Online_BookStore_Management_System.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    void deleteByBookId(int bookId);
}

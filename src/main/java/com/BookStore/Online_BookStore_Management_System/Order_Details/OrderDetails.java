package com.BookStore.Online_BookStore_Management_System.Order_Details;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Order.Order;

public class OrderDetails {
    private Order order_id; // foreign Key (Relationship to order)
    private Book book_id; // foreign Key (Relationship to books)
    private int quantity;
}

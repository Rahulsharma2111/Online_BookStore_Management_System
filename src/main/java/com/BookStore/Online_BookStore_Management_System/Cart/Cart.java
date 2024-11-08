package com.BookStore.Online_BookStore_Management_System.Cart;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "user_cart")
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id ;

   @ManyToOne()
   @JoinColumn(name = "user_id", referencedColumnName = "id")  // Foreign key to User entity
   private User user ;  // foreign Key (Relationship to user)
   @ManyToOne()
   @JoinColumn(name = "book_id", referencedColumnName = "id")  // Foreign key to Book entity
   private Book book;  // foreign Key (Relationship to Books)
   private int quantity;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Book getBook() {
      return book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}

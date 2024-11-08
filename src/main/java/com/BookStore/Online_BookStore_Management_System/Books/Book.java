package com.BookStore.Online_BookStore_Management_System.Books;

import com.BookStore.Online_BookStore_Management_System.Cart.Cart;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BooksDetails")
public class Book {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;

       @Column
       private String title;
       private String author;
       private Double price;
       private String category;
       private int stock;
       private String description;

//       Book image for preview
//      private String image;

//       @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)  // Enable cascading deletes
//     private List<Cart> carts;  // This will automatically delete associated carts when the book is deleted

//       public Book() {
//       }

//       public Book(int id, String title, String author, Double price, String category, int stock, String description, List<Cart> carts) {
//              this.id = id;
//              this.title = title;
//              this.author = author;
//              this.price = price;
//              this.category = category;
//              this.stock = stock;
//              this.description = description;
//              this.carts = carts;
//       }
//       public Book(int id, String title, String author, Double price, String category, int stock, String description) {
//              this.id = id;
//              this.title = title;
//              this.author = author;
//              this.price = price;
//              this.category = category;
//              this.stock = stock;
//              this.description = description;
//       }
       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getTitle() {
              return title;
       }

       public void setTitle(String title) {
              this.title = title;
       }

       public String getAuthor() {
              return author;
       }

       public void setAuthor(String author) {
              this.author = author;
       }

       public Double getPrice() {
              return price;
       }

       public void setPrice(Double price) {
              this.price = price;
       }

       public String getCategory() {
              return category;
       }

       public void setCategory(String category) {
              this.category = category;
       }

       public int getStock() {
              return stock;
       }

       public void setStock(int stock) {
              this.stock = stock;
       }

       public String getDescription() {
              return description;
       }

       public void setDescription(String description) {
              this.description = description;
       }

//       public List<Cart> getCarts() {
//              return carts;
//       }

//       public void setCarts(List<Cart> carts) {
//              this.carts = carts;
//       }
}

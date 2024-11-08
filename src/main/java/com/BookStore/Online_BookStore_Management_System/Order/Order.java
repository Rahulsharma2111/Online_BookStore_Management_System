package com.BookStore.Online_BookStore_Management_System.Order;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "`order`")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@ManyToOne
@JoinColumn(name = "user_id")  //,referencedColumnName = "id"
//@Column(name = "user_id")
    private User user;     // foreign Key (Relationship to user)
    @ManyToOne
    @JoinColumn(name = "book_id")  //,referencedColumnName = "id"
//    @Column(name = "book_id")
    private Book book;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private int quantity;
    private Double total;
    private String status;
    // Processing, shipped, delivered


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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.BookStore.Online_BookStore_Management_System.Order;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Books.BookServices;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import com.BookStore.Online_BookStore_Management_System.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BookServices bookServices;

//    public List<Order> orderList;
    public Order orderByUser(User user,Book book,int quantity) {


        Order newOrder=new Order();
        newOrder.setUser(user);
        newOrder.setBook(book);
        newOrder.setDate(LocalDateTime.now());
        newOrder.setQuantity(quantity);
        newOrder.setTotal(quantity* book.getPrice());
        newOrder.setStatus("delivered");
        // Processing, shipped, delivered
        return this.orderRepository.save(newOrder);
    }

    public List<Order> findOrderById(int userId) {
        List<Order> orderList =this.orderRepository.findByUser_Id(userId);
return orderList;
    }

    public List<Order> getAllOrder() {
        List<Order> orderList =this.orderRepository.findAll();
        return orderList;
    }

    public String adminDashboard(){
        return "adminDashboard";
    }

//    ❌❌❌❌❌❌❌❌❌❌
public List<Order> getAllOrders() {
    return orderRepository.findAll();  // Retrieve all orders from the database
}

}

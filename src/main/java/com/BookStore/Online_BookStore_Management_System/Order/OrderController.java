package com.BookStore.Online_BookStore_Management_System.Order;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Books.BookServices;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import com.BookStore.Online_BookStore_Management_System.Users.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;
    @Autowired
    private UserService userService;
    @Autowired
    private BookServices bookServices;
    @PostMapping("")
    @ResponseBody
    public Order orderByUser(@RequestParam("userId") int userId,
                             @RequestParam("bookId") int bookId,
                             @RequestParam("quantity") int quantity){
        User user_id= this.userService.findUserById(userId).get();
        Book book_id= this.bookServices.findBookById(bookId).get();
        return this.orderServices.orderByUser(user_id,book_id,quantity);
    }


    @GetMapping("/{userId}")
    @ResponseBody
    public  List<Order>  fetchAllOrderByUserId(@PathVariable("userId") int userId){
        return this.orderServices.findOrderById(userId);
    }


//❌❌❌❌❌
    @GetMapping("/get")
    public String getAllOrders(Model model) {
        List<Order> orders = orderServices.getAllOrders();
        model.addAttribute("orders", orders);
        return "data-list";  // Thymeleaf template name (order-list.html)
    }

    @GetMapping("/mess")
    public String getMessage(Model model) {
        model.addAttribute("ms", "this is message text");
        return "message";
    }

    @GetMapping("/id/{userId}")
    public String fetchOrderByUserId(@PathVariable("userId") int userId,Model model){

        List<Order> orders = this.orderServices.findOrderById(userId);
        model.addAttribute("orders",orders);
        return "data";
    }
}

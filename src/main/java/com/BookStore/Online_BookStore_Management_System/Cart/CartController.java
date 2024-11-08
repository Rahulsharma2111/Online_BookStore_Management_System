package com.BookStore.Online_BookStore_Management_System.Cart;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Books.BookServices;
import com.BookStore.Online_BookStore_Management_System.Users.User;
//import com.BookStore.Online_BookStore_Management_System.Users.UserService;
import com.BookStore.Online_BookStore_Management_System.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookServices bookServices;

    @PostMapping("/add")
    public Cart addToCart(@RequestParam("userId") int userId,
                          @RequestParam("bookId") int bookId,
                          @RequestParam("quantity") int quantity) {
        // Retrieve user and book entities from the database (assumes you have user and book services)
        Optional<User> user = userService.findUserById(userId);  // This requires a UserService class to fetch user data.
        Optional<Book> book = bookServices.findBookById(bookId);  // This requires a BookService class to fetch book data.
       User existingUser=user.get();
        Book existingBook=book.get();
        // Add the item to the cart
        return this.cartService.addToCart(existingUser, existingBook, quantity);
    }

    @DeleteMapping("/remove/{cartId}")
    public boolean deleteCartItem(@PathVariable("cartId")int cartId){
        return this.cartService.removeItemFormCart(cartId);
    }
}
//POST /cart/add?userId=1&bookId=2&quantity=3
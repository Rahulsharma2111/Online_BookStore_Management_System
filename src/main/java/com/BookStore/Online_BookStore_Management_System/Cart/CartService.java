package com.BookStore.Online_BookStore_Management_System.Cart;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import com.BookStore.Online_BookStore_Management_System.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public Cart addToCart(User user, Book book, int quantity) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setBook(book);
        cart.setQuantity(quantity);

        return this.cartRepository.save(cart);
    }

    public boolean removeItemFormCart(int cartId) {
        this.cartRepository.deleteById(cartId);
        return true;
    }
}

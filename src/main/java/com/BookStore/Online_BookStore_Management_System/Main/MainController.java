package com.BookStore.Online_BookStore_Management_System.Main;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String mainpage(){
        return "index";
    }
}

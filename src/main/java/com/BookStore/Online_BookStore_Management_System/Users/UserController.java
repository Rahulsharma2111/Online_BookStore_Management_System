package com.BookStore.Online_BookStore_Management_System.Users;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService userService;
    @GetMapping("/get")
    @ResponseBody
    public List<User> getAllBooks() {
        return this.userService.getAllUsers();
    }


    @GetMapping("/user-signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User()); // Assuming you have a User class
        return "userSignup";
    }

    @PostMapping("/user-signup")
    public String processSignup(@ModelAttribute User user) {
        this.userService.saveUsers(user);
        return "redirect:/user/user-signup"; // Redirect to a success page after signup
    }
//    @PostMapping("/save")
//    public User saveUserData(@RequestBody User user) {
//        return this.userService.saveUsers(user);
//    }

    @PostMapping("/update/{username}")
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable("username") String username) {
        return this.userService.updateUsers(user,username);
    }
    @PostMapping("/{id}")
    @ResponseBody
    public User updateUserById(@RequestBody User user, @PathVariable("id") int id) {
        return this.userService.updateUsersById(user,id);
    }


}

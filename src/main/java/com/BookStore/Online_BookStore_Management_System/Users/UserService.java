package com.BookStore.Online_BookStore_Management_System.Users;

import com.BookStore.Online_BookStore_Management_System.Books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
@Autowired
private UserRepository userRepository;

    public Optional<User> findUserById(int id){
        Optional<User> user= this.userRepository.findById(id);
        return user;
    }
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User saveUsers( User user) {
        return this.userRepository.save(user);
    }

    public User updateUsers( User user,String username) {
       User userUpdated=this.userRepository.findByUsername(username);

        if(userUpdated==null){
            return null;
        }
        userUpdated.setUsername(user.getUsername());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setRole(user.getRole());
        userUpdated.setAddress(user.getAddress());
        return this.userRepository.save(userUpdated);
    }

    public User updateUsersById( User user,int id) {
        Optional<User> userUpdated=this.userRepository.findById(id);

        if(!userUpdated.isPresent()){
            return null;
        }
        User existingUser=userUpdated.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setAddress(user.getAddress());
        return this.userRepository.save(existingUser);
    }




}

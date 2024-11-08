package com.BookStore.Online_BookStore_Management_System.Users;

import com.BookStore.Online_BookStore_Management_System.Cart.Cart;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "UserData")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String username;
   private String  password;
   private String email;
   private String role;
   private String address;

//   @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)  // Enable cascading deletes
//   private List<Cart> carts;  // This will automatically delete associated carts when the book is deleted

   public User() {
   }

   public User(int id, String username, String password, String email, String role, String address) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.email = email;
      this.role = role;
      this.address = address;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

//   public List<Cart> getCarts() {
//      return carts;
//   }

//   public void setCarts(List<Cart> carts) {
//      this.carts = carts;
//   }
}

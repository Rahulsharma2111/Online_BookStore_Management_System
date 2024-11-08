package com.BookStore.Online_BookStore_Management_System.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   User findByUsername(String username);
}

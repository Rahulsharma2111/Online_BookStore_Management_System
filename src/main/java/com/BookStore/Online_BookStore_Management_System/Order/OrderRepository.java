package com.BookStore.Online_BookStore_Management_System.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public List<Order> findByUser_Id(int id);
}

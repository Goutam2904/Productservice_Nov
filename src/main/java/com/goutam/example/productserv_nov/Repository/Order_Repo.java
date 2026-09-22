package com.goutam.example.productserv_nov.Repository;

import com.goutam.example.productserv_nov.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Order_Repo extends JpaRepository<Order, Long> {
    List<Order> findByUserIdOrderByCreatedAtDesc(long userId);
}

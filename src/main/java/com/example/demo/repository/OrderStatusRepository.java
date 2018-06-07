package com.example.demo.repository;

import com.example.demo.model.Buyer;
import com.example.demo.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}

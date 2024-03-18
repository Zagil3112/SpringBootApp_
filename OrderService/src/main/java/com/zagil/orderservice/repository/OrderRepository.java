package com.zagil.orderservice.repository;
import com.zagil.orderservice.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
package com.nakamas.ms_orders.repository;

import com.nakamas.ms_orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientNameContainingIgnoreCase(String clientName);
}

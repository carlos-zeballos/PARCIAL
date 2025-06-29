package com.nakamas.ms_orders.service;

import com.nakamas.ms_orders.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    List<Order> searchOrdersByClient(String client);
    List<Order> searchOrdersByStatus(String status);
}

package com.nakamas.ms_orders.controller;

import com.nakamas.ms_orders.model.Order;
import com.nakamas.ms_orders.exception.ResourceNotFoundException;
import com.nakamas.ms_orders.service.IOrderService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> optionalOrder = orderService.getOrderById(id);
        Order order = optionalOrder
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/search/client")
public ResponseEntity<List<Order>> searchOrdersByClient(@RequestParam("client") String client) {
    List<Order> orders = orderService.searchOrdersByClient(client);
    return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

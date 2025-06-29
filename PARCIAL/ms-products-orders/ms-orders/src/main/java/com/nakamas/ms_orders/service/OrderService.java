package com.nakamas.ms_orders.service;

import com.nakamas.ms_orders.model.Order;
import com.nakamas.ms_orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    // Inyección por constructor
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    

    @Override
    public Order createOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        order.setStatus("PENDING");
        if (order.getClientName() == null || order.getClientName().trim().isEmpty()) {
            throw new IllegalArgumentException("Client name must not be null or empty");
        }
        return order;
        
    }

    @Override
    public List<Order> getAllOrders() {
        return null; // Aquí deberías implementar la lógica para obtener todas las órdenes
       
    }

    @Override
public Optional<Order> getOrderById(Long id) {
    if (id == null) {
        throw new IllegalArgumentException("Order ID must not be null");
    }
    return null;
}


@Override
public List<Order> searchOrdersByClient(String client) {
    // Elimina espacios en blanco alrededor y valida el nombre del cliente
    String trimmedClient = client != null ? client.trim() : "";

    if (trimmedClient.isEmpty()) {
        throw new IllegalArgumentException("Client name must not be null or empty");
    }

    // Realiza búsqueda insensible a mayúsculas
    return orderRepository.findByClientNameContainingIgnoreCase(trimmedClient); 
}

@Override
public List<Order> searchOrdersByStatus(String status) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchOrdersByStatus'");
}   

}
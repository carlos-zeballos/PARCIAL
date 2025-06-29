package com.nakamas.ms_orders.repository; // O el paquete correcto de tus repositorios, si es diferente a la raíz

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository; // Opcional, Spring lo detecta al extender JpaRepository

import com.nakamas.ms_orders.model.Order;

// Esta es la forma correcta para una interfaz de repositorio
public interface IOrderRepository extends JpaRepository<Order, Long> {
    // Aquí puedes definir métodos adicionales si es necesario
        // Por ejemplo, para buscar órdenes por estado, cliente, etc.
        
        
    }
    
    
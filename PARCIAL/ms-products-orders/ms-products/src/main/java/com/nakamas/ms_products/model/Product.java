package com.nakamas.ms_products.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false, length = 0)
    private Double price;

    @Column(nullable = false, length = 0)
    private Integer stock;

    @Column(nullable = false, length = 50)
    private String category;
}

package com.nakamas.ms_products.repository;

import com.nakamas.ms_products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Page<Product> searchProducts(String name, Pageable pageable);

    Integer getProductStock(Long id);
}

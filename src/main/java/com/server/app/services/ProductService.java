package com.server.app.services;

import com.server.app.dto.ProductDto;
import com.server.app.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();

    Product findById(UUID id);

    void deleteById(UUID id);

    Product create(Product product);

    Product update(UUID id, ProductDto product);
}

package com.server.app.services.impl;

import com.server.app.dto.ProductDto;
import com.server.app.entities.Product;
import com.server.app.repositories.ProductRepository;
import com.server.app.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(UUID id, ProductDto product) {

        var productEntity = productRepository.findById(id).orElse(null);
        if (productEntity == null) return  null;

        productEntity.setName(product.getName());
        productEntity.setAvailable(product.getAvailable());
        productEntity.setPrice(product.getPrice());
        return productRepository.save(productEntity);
    }
}

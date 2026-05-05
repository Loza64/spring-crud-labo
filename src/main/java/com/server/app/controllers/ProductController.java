package com.server.app.controllers;

import com.server.app.dto.ProductDto;
import com.server.app.entities.Product;
import com.server.app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto product) {

        Product data = new Product();
        data.setAvailable(product.getAvailable());
        data.setName(product.getName());
        data.setPrice(product.getPrice());

        service.create(data);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(data);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts() {
        var list = service.findAll();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(list);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID id) {
        var data = service.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("product deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody ProductDto product) {

        var update = service.update(id, product);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(update);
    }
}

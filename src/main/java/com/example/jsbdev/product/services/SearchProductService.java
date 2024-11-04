package com.example.jsbdev.product.services;

import com.example.jsbdev.product.ProductRepository;
import com.example.jsbdev.product.Query;
import com.example.jsbdev.product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductService implements Query<String, List<ProductDTO>> {
    public SearchProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String name) {
        // JPA
        return ResponseEntity.ok(productRepository.findByNameContaining(name)
                .stream()
                .map(ProductDTO::new)
                .toList());

        // JPQL
//        return ResponseEntity.ok(productRepository.findByNameOrDescriptionContaining(name)
//                .stream()
//                .map(ProductDTO::new)
//                .toList());
    }
}

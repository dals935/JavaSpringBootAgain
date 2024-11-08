package com.example.jsbdev.product.services;

import com.example.jsbdev.exceptions.ProductNotFoundException;
import com.example.jsbdev.product.ProductRepository;
import com.example.jsbdev.product.Query;
import com.example.jsbdev.product.model.Product;
import com.example.jsbdev.product.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {
    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(GetProductService.class);

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        logger.info("Executing " + getClass() + " input: " + input);
        Optional<Product> productOptional = productRepository.findById(input);
        if(productOptional.isPresent()){
            return  ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();
    }
}

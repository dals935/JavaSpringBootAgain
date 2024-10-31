package com.example.jsbdev.product.services;

import com.example.jsbdev.exceptions.ErrorMessages;
import com.example.jsbdev.exceptions.ProductNotValidException;
import com.example.jsbdev.product.Command;
import com.example.jsbdev.product.ProductRepository;
import com.example.jsbdev.product.model.Product;
import com.example.jsbdev.product.model.ProductDTO;
import com.example.jsbdev.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

//        ProductValidator.execute(product);

        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

}

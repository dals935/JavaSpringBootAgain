package com.example.jsbdev.product.services;

import com.example.jsbdev.exceptions.ProductNotFoundException;
import com.example.jsbdev.product.Command;
import com.example.jsbdev.product.ProductRepository;
import com.example.jsbdev.product.model.Product;
import com.example.jsbdev.product.model.ProductDTO;
import com.example.jsbdev.product.model.UpdateProductCommand;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CachePut(value = "productCache", key = "#command.getId()")
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {

        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
//            ProductValidator.execute(product);
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        throw new ProductNotFoundException();
    }

}

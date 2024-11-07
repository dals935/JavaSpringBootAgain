package com.example.jsbdev;

import com.example.jsbdev.exceptions.ProductNotFoundException;
import com.example.jsbdev.product.ProductRepository;
import com.example.jsbdev.product.model.Product;
import com.example.jsbdev.product.model.ProductDTO;
import com.example.jsbdev.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GetProductServiceTest {

    @Mock // needed dependency to run test
    private ProductRepository productRepository;

    @InjectMocks // what we are testing
    private GetProductService getProductService;

    @BeforeEach // things we need before testing runs
    public void setup() {
        // Initializes the repository and the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void  give_product_exists_when_get_product_service_return_product_dto() {
        //Given
        Product product = new Product();
        product.setId(1);
        product.setName("Product Name");
        product.setDescription("Product Name Description with at least 20 characters");
        product.setPrice(9.99);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        //When
        ResponseEntity<ProductDTO> response = getProductService.execute(1);

        //Then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response);
        verify(productRepository, times(1)).findById(1);
    }

    @Test
    void given_product_does_not_exists_when_get_product_service_throw_product_not_found_exception(){

        //Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        //When & Then
        assertThrows(ProductNotFoundException.class, () -> getProductService.execute(1));
        verify(productRepository, times(1)).findById(1);

    }
}

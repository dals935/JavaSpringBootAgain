package com.example.jsbdev.validators;

import com.example.jsbdev.exceptions.ErrorMessages;
import com.example.jsbdev.exceptions.ProductNotValidException;
import com.example.jsbdev.product.model.Product;
import org.springframework.util.StringUtils;

public class ProductValidator {

    private ProductValidator(){

    }

    public static void execute(Product product) {
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }

        if(product.getDescription().length() < 20){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGTH.getMessage());
        }

        if(product.getPrice() == null || product.getPrice() < 0.00){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }

}

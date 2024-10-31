package com.example.jsbdev.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    NAME_REQUIRED("Name is Required"),
    DESCRIPTION_LENGTH("Description must be 20 Characters long"),
    PRICE_CANNOT_BE_NEGATIVE("Price cannot be Negative");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

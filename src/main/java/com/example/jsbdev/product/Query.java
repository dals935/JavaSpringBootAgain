package com.example.jsbdev.product;

import org.springframework.http.ResponseEntity;

public interface Query <I, O> {

    ResponseEntity<O> execute(I input);

}

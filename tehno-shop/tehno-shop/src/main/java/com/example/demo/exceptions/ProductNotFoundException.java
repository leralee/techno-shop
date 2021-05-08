package com.example.demo.exceptions;

import com.example.demo.model.Product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

package com.igordsanches.mrdeliveryspringboot.controller;

import com.igordsanches.mrdeliveryspringboot.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ProductControllerAdvice  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<Object> capturaErroNull() {

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
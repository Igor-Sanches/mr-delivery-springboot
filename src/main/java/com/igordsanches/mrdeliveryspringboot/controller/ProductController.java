package com.igordsanches.mrdeliveryspringboot.controller;

import com.igordsanches.mrdeliveryspringboot.entity.Product;
import com.igordsanches.mrdeliveryspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception {

        product = service.save(product);

        return ResponseEntity.ok().body(product);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> searchProduct(@PathVariable Long id) {

        Product prod = service.findById(id);

        return ResponseEntity.ok().body(prod);

    }

}

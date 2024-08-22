package com.igordsanches.mrdeliveryspringboot.service;

import com.igordsanches.mrdeliveryspringboot.entity.Product;
import com.igordsanches.mrdeliveryspringboot.exception.ProductException;
import com.igordsanches.mrdeliveryspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product produto) throws Exception {
        if (produto.getName() == null || produto.getPrice() == null)
            throw new ProductException();
        if (produto.getPrice() < 0)
            throw new ProductException();
        return repository.save(produto);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}

package com.igordsanches.mrdeliveryspringboot.service;

import com.igordsanches.mrdeliveryspringboot.entity.Order;
import com.igordsanches.mrdeliveryspringboot.entity.Product;
import com.igordsanches.mrdeliveryspringboot.repository.OrderRepository;
import com.igordsanches.mrdeliveryspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order save(Order order) {
        Set<Product> products = new HashSet<>();

        order.setOrderDate(LocalDateTime.now());
        order.getProducts().forEach(product -> {
            products.add(productRepository.getById(product.getId()));
        });
        order.setProducts(products);

        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

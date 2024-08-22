package com.igordsanches.mrdeliveryspringboot.controller;

import com.igordsanches.mrdeliveryspringboot.entity.Order;
import com.igordsanches.mrdeliveryspringboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {

        order = service.save(order);

        return ResponseEntity.ok().body(order);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> searchOrder(@PathVariable Long id) {

        Order order = service.findById(id);

        return ResponseEntity.ok().body(order);

    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<List<Order>> searchAllOrders() {

        List<Order> orders = service.findAll();

        return ResponseEntity.ok().body(orders);

    }

}

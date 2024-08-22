package com.igordsanches.mrdeliveryspringboot.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private String customerId;
    private String customerAddress;
    private LocalDateTime orderDate;
    private boolean status;

    @ManyToMany
    @Fetch(FetchMode.SELECT)
    private Set<Product> products;

}

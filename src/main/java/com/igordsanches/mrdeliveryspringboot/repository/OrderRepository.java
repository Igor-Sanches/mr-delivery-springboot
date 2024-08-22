package com.igordsanches.mrdeliveryspringboot.repository;

import com.igordsanches.mrdeliveryspringboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   Order findByOrderNumber(String orderNumber);
}

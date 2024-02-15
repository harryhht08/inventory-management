package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Order;
import com.example.inventorymanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order processedOrder = orderService.processOrder(order);
        return ResponseEntity.ok(processedOrder);
    }

    // Additional endpoints as needed
}

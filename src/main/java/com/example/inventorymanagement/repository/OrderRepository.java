package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

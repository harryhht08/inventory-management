package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

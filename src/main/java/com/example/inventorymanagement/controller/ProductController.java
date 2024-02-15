package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Product> getAllProducts() {
        return inventoryService.findAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return inventoryService.saveProduct(product);
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<?> updateProductQuantity(@PathVariable String id, @RequestParam int quantity) {
        inventoryService.updateProductQuantity(id, quantity);
        return ResponseEntity.ok().build();
    }
}

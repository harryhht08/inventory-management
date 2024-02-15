package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.Order;
import com.example.inventorymanagement.model.OrderStatus;
import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.OrderRepository;
import com.example.inventorymanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order processOrder(Order order) {
        // Iterate over each OrderItem in the Order
        order.getItems().forEach(item -> {
            Optional<Product> productOptional = productRepository.findById(item.getProductId());
            productOptional.ifPresentOrElse(product -> {
                // Check if enough inventory is available
                if (product.getQuantity() >= item.getQuantity()) {
                    // Deduct the ordered quantity from the inventory
                    product.setQuantity(product.getQuantity() - item.getQuantity());
                    productRepository.save(product);
                } else {
                    // Handle the case where there isn't enough inventory
                    throw new RuntimeException("Not enough inventory for product: " + item.getProductId());
                }
            }, () -> {
                throw new RuntimeException("Product not found: " + item.getProductId());
            });
        });

        // Set the order status to PROCESSING (or any other logic you need)
        order.setStatus(OrderStatus.PROCESSING);

        // Save the updated order
        return orderRepository.save(order);
    }

    // Implement other required methods here
}

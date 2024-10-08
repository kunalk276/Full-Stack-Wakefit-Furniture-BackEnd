package com.wakefit.ecommerce.controller;

import com.wakefit.ecommerce.entity.Order;
import com.wakefit.ecommerce.entity.Product;
import com.wakefit.ecommerce.service.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/Order/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/Order/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
    @GetMapping("/Order/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
   
}

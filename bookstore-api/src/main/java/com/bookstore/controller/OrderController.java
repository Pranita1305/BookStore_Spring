package com.bookstore.controller;

import com.bookstore.entity.Order;
import com.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody List<Long> bookIds,
                            @AuthenticationPrincipal UserDetails userDetails) {
        return orderService.placeOrder(userDetails.getUsername(), bookIds);
    }

    @GetMapping
    public List<Order> getMyOrders(@AuthenticationPrincipal UserDetails userDetails) {
        return orderService.getOrdersByUsername(userDetails.getUsername());
    }
}

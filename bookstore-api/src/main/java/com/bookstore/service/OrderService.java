package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.entity.Order;
import com.bookstore.entity.User;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private BookRepository bookRepo;

    public Order placeOrder(String username, List<Long> bookIds) {
        User user = userRepo.findByUsername(username).orElseThrow();
        List<Book> books = bookRepo.findAllById(bookIds);

        double total = books.stream().mapToDouble(Book::getPrice).sum();

        Order order = new Order();
        order.setUser(user);
        order.setBooks(books);
        order.setTotal(total);
        return orderRepo.save(order);
    }

    public List<Order> getOrdersByUsername(String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        return orderRepo.findAll().stream()
                .filter(o -> o.getUser().getId().equals(user.getId()))
                .toList();
    }
}

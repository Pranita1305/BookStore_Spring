package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired private BookRepository bookRepo;
    private double price;

    public List<Book> getAllBooks() { return bookRepo.findAll(); }

    public Book addBook(Book book) { return bookRepo.save(book); }

    public void deleteBook(Long id) { bookRepo.deleteById(id); }

    public double getPrice() {
        return price;
    }

}

package com.example.library_management_system.controller;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.OK);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") long bookId) {
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long bookId, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(bookId, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long bookId) {
        Book deleteBook = bookService.deleteBook(bookId);
        return new ResponseEntity<>(deleteBook, HttpStatus.OK);
    }
}

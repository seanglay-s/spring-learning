package com.example.library_management_system.controller;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.OK);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book")
    public ResponseEntity<Book> getBook(@RequestParam(name = "bookId") long bookId) {
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestParam(name = "bookId") long bookId, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(bookId, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/book")
    public ResponseEntity<Book> deleteBook(@RequestParam(name = "bookId") long bookId) {
        Book deleteBook = bookService.deleteBook(bookId);
        return new ResponseEntity<>(deleteBook, HttpStatus.OK);
    }
}

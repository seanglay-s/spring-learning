package com.example.library_management_system.service;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Book updateBook(long bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Not Found"));

        // Update the existing book's fields with the new values
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setCategory(book.getCategory());
        existingBook.setAvailabilityStatus(book.getAvailabilityStatus());
        existingBook.setPublishedDate(book.getPublishedDate());
        existingBook.setTotalCopies(book.getTotalCopies());
        existingBook.setAvailableCopies(book.getAvailableCopies());
        bookRepository.save(existingBook);
        return existingBook;
    }

    public Book deleteBook(long bookId) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Not Found"));
        bookRepository.deleteById(bookId);
        return existingBook;
    }
}




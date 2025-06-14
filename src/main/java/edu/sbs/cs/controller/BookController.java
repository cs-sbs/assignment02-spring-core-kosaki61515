package edu.sbs.cs.controller;


import edu.sbs.cs.entity.Book;
import edu.sbs.cs.entity.User;
import edu.sbs.cs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/all")
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(bookService.getAllBooks(page, size));
    }

    @PostMapping("/paging")
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String sortedField,
            @RequestParam String sortedDirection
    ) {
        return ResponseEntity.ok(bookService.getAllBooks(page, size, sortedField, sortedDirection));
    }

    @PostMapping("/author/{authorId}/books")
    public ResponseEntity<Book> addBookToAuthor(
            @PathVariable Long authorId,
            @RequestBody Book book
    ) {
        return ResponseEntity.ok(bookService.addBookToAuthor(authorId, book));
    }

    @GetMapping("/author/{authorId}/books")
    public ResponseEntity<List<Book>> getBookByAuthorId(
            @PathVariable Long authorId
    ) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(authorId));
    }
}

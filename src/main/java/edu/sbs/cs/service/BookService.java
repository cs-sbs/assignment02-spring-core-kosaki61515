package edu.sbs.cs.service;

import edu.sbs.cs.entity.Author;
import edu.sbs.cs.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<Book> getAllBooks(int page, int size);

    Page<Book> getAllBooks(int page, int size, String sortField, String sortDirection);

    Book addBookToAuthor(long authorId, Book book);

    List<Book> getBooksByAuthor(long authorId);
}

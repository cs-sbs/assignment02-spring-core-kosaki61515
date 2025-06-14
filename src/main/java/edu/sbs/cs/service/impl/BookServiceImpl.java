package edu.sbs.cs.service.impl;

import edu.sbs.cs.entity.Author;
import edu.sbs.cs.entity.Book;
import edu.sbs.cs.repository.AuthorRepository;
import edu.sbs.cs.repository.BookPagingRepository;
import edu.sbs.cs.service.BookService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookPagingRepository bookPagingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Book> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> paging = bookPagingRepository.findAll(pageable);
        return paging;
    }

    public Page<Book> getAllBooks(int page, int size, String sortField, String sortDirection) {
        Sort sort;
        if (sortDirection.equals("asc")) {
            sort = Sort.by(sortField).ascending();
        } else {
            sort = Sort.by(sortField).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> paging = bookPagingRepository.findAll(pageable);
        return paging;
    }

    public Book addBookToAuthor(long authorId, Book book) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceAccessException("Author not found")
        );
        author.addBook(book);
        return bookPagingRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> getBooksByAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceAccessException("Author not found")
        );
        Hibernate.initialize(author.getBooks());
        return author.getBooks();
    }

}

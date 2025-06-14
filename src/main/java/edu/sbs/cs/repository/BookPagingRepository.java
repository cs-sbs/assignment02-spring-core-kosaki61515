package edu.sbs.cs.repository;

import edu.sbs.cs.entity.Author;
import edu.sbs.cs.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookPagingRepository  extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    List<Book> findUsersByAuthor(Author author);

}

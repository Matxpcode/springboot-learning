package com.wreckcode.app.management.book_catalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wreckcode.app.management.book_catalog.exception.BookNotFoundException;
import com.wreckcode.app.management.book_catalog.model.Book;
import com.wreckcode.app.management.book_catalog.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Book findbyId(Long id) {
    Book book = bookRepository.findById(id);

    if (book == null) {
      throw new BookNotFoundException("Book not found with id: " + id);
    }
    return book;
  }

  @Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book update(Book book) {
    // primero verificamos q el libro exista
    findbyId(book.getId());

    return bookRepository.update(book);
  }

}

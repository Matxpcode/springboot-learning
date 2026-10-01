package com.wreckcode.app.management.book_catalog.service;

import java.util.List;

import com.wreckcode.app.management.book_catalog.model.Book;

public interface BookService {
  public List<Book> findAll();

  public Book findbyId(Long id);

  public Book save(Book book);

  public Book update(Book book);
}

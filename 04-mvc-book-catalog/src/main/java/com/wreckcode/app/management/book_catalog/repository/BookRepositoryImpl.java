package com.wreckcode.app.management.book_catalog.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wreckcode.app.management.book_catalog.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
  private Long nextId = 4L;
  private final List<Book> books = new ArrayList<>();

  public BookRepositoryImpl() {
    books.add(new Book(1L, "Clean Code", "Robert C. Martin", 45.90));
    books.add(new Book(2L, "Effective Java", "Joshua Blonch", 50.00));
    books.add(new Book(3L, "Java: The Complete Reference", "Herberd Schildt", 55.00));
  }

  @Override
  public List<Book> findAll() {
    return books;
  }

  @Override
  public Book findById(Long id) {
    for (Book book : books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }

  @Override
  public Book save(Book book) {
    // modificamos el id
    book.setId(nextId);

    nextId++;

    books.add(book);

    return book;
  }

  @Override
  public Book update(Book book) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getId().equals(book.getId())) {
        books.set(i, book);
        return book;
      }
    }
    return null;
  }

}

package com.wreckcode.app.management.book_catalog.repository;

import java.util.List;

import com.wreckcode.app.management.book_catalog.model.Book;

public interface BookRepository {
  // Metodo para listar todos los libros
  public List<Book> findAll();

  // Metodo para encontrar libro por id
  public Book findById(Long id);

  // Metodo para guardar libro
  public Book save(Book book);

  // Metodo para actualizar libro
  public Book update(Book book);

  // Metodo para eliminar libro

}

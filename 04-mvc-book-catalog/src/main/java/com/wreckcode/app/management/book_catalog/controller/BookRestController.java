package com.wreckcode.app.management.book_catalog.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wreckcode.app.management.book_catalog.model.Book;
import com.wreckcode.app.management.book_catalog.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
  private final BookService service;

  // inyeccion de dependencias
  public BookRestController(BookService service) {
    this.service = service;
  }

  // METODOS GET

  // metodo para listar todo
  @GetMapping
  public List<Book> findAll() {
    return service.findAll();
  }

  // metodo para buscar por id
  @GetMapping("/{id}")
  public Book findById(@PathVariable Long id) {
    return service.findbyId(id);
  }

  // METODOS POST

  // metodo para insertar un libro nuevo
  // RequestBody recibe el json del cliente y lo convierte en objeto book
  @PostMapping
  public Book save(@RequestBody Book book) {
    return service.save(book);
  }

}

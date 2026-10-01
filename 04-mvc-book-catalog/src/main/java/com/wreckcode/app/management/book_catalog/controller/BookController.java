package com.wreckcode.app.management.book_catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wreckcode.app.management.book_catalog.model.Book;
import com.wreckcode.app.management.book_catalog.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  // METODOS GET

  // metodo para listar todos los libros
  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("books", service.findAll());
    return "books";
  }

  // metodo para buscar libro por id
  @GetMapping("/{id}")
  public String findById(@PathVariable Long id, Model model) {
    // paso1, buscamos el libro usando el id en la ruta
    Book book = service.findbyId(id);

    // paso2, enviamos el libro a thymeleaf
    model.addAttribute("book", book);

    // paso3, indicamos la vista que queremos renderizar (ruta html)
    return "book-detail";
  }

  // metodo para agregar uno nuevo libro (form vacio para insertar)
  @GetMapping("/new")
  public String newBook(Model model) {
    model.addAttribute("book", new Book(null, "", "", null));
    return "book-form";
  }

  // metodo para actualizar libro (form con datos del libro indicado)
  @GetMapping("/{id}/edit")
  public String editBook(@PathVariable Long id, Model model) {
    Book book = service.findbyId(id);

    model.addAttribute("book", book);
    return "book-form";
  }

  // METODOS POST

  // metodo para guardar libro nuevo, recibe datos del form
  @PostMapping
  public String save(@ModelAttribute Book book) {
    service.save(book);

    return "redirect:/books";
  }

  // metodo para actualizar datos del libro antiguo, mismo form
  @PostMapping("/{id}")
  public String update(@PathVariable Long id, @ModelAttribute Book book) {
    book.setId(id); // en el form no indicamos id, por ello le asignamos el valor q viene en ruta

    service.update(book);
    return "redirect:/books";
  }

}

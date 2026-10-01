package com.wreckcode.app.management.book_catalog.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // cuando detecte el error normal deténlo y ejecuta el metodo
  // BookNotFoundException
  @ExceptionHandler(BookNotFoundException.class)

  // indica codigo http q recibira el cliente, cambiamos a error 404 como recurso
  // no encontrado
  @ResponseStatus(HttpStatus.NOT_FOUND)

  // metodo que nos devolvera un json clave-valor
  public Map<String, String> handleBookNotFound(BookNotFoundException exception) {
    return Map.of("error", exception.getMessage());
  }

}

package com.wreckcode.app.exception_handling.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wreckcode.app.exception_handling.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

  @ExceptionHandler({ ArithmeticException.class })
  public ResponseEntity<Error> divisionByZero(Exception ex) {
    Error error = new Error();
    error.setDate(new Date());
    error.setError("Error division por cero!");
    error.setMessage(ex.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    // Forma 1
    // return ResponseEntity.internalServerError().body(error);

    // Forma 2
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
  }

}

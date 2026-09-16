package com.wreckcode.app.exception_handling.springboot_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/app")
  public String index() {
    int value = 100 / 0;

    System.out.println(value);
    return "ok 200";
  }
}

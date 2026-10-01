package com.wreckcode.app.management.book_catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
  private Long id;
  private String title;
  private String author;
  private Double price;
}

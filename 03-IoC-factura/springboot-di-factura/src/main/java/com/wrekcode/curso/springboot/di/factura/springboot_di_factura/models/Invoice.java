package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
  private final Client client;

  private final String description;

  private final List<Item> items;

  // Inyeccion de dependencias
  Invoice(Client client, @Value("${invoice.description.office}") String description,
      @Qualifier("default") List<Item> items) {
    this.client = client;
    this.description = description;
    this.items = items;
  }

  public Client getClient() {
    return client;
  }

  public String getDescription() {
    return description;
  }

  public List<Item> getItems() {
    return items;
  }

  public int getTotal() {

    // forma 1: usando foreach
    /*
     * int Itotal = 0;
     * foreachr (Item item : items) {
     * Itotal += item.getImporte();
     * }
     * return Itotal;
     */

    // forma 2: usando api stream - programacion funcional
    return items.stream()
        .map(item -> item.getImporte())
        .reduce(0, (sum, importe) -> sum + importe);
  }
}

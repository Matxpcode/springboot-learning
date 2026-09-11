package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {
  private final Client client;

  private final String description;

  private final List<Item> items;

  // Inyeccion de dependencias - Contructor
  Invoice(Client client, @Value("${invoice.description.office}") String description,
      @Qualifier("default") List<Item> items) {
    this.client = client;
    this.description = description; // Factura de oficina
    this.items = items;
  }

  // PostConstructor
  @PostConstruct
  public void init() {
    // Aqui no se inyecta nada
    // se usa las variables que el constructor ya creo
    System.out.println("Factura lista para: " + client.getName());
    System.out.println(
        description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname()));
  }

  // Predestroy
  @PreDestroy
  public void destroy() {
    System.out.println("Destruyendo el componente o bean invoice!");
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

package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
// @JsonIgnoreProperties({ "targetSource", "advisors" })
public class Invoice {

  private Client client;

  private String description;

  private List<Item> items;

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
    client.setName(client.getName().concat(" Pepe"));
    description = description.concat(" del cliente: ").concat(client.getName()).concat(" ")
        .concat(client.getLastname());
  }

  // Predestroy
  @PreDestroy
  public void destroy() {
    System.out.println("Destruyendo el componente o bean invoice!");
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  // Inyeccion de dependencias - Contructor
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

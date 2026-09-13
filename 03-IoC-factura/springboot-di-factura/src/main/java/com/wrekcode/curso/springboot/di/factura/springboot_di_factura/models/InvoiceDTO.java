package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import java.util.List;

public class InvoiceDTO {
  private ClientDTO client;
  private String description;
  private List<Item> items;

  public InvoiceDTO() {
  }

  public InvoiceDTO(ClientDTO client, String description, List<Item> items) {
    this.client = client;
    this.description = description;
    this.items = items;
  }

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
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
}

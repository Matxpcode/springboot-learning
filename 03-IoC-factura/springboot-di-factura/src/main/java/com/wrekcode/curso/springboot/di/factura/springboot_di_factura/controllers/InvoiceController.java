package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Client;
import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.ClientDTO;
import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Invoice;
import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.InvoiceDTO;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

  private Invoice invoice;

  InvoiceController(Invoice invoice) {
    this.invoice = invoice;
  }

  @GetMapping("/show")
  public InvoiceDTO show() {
    InvoiceDTO i = new InvoiceDTO();

    ClientDTO c = new ClientDTO();
    c.setName(invoice.getClient().getName());
    c.setLastname(invoice.getClient().getLastname());

    i.setClient(c);
    i.setDescription(invoice.getDescription());
    i.setItems(invoice.getItems());
    return i;
  }

}

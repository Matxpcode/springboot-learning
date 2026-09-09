package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("/invoices")
public class InvoiceController {

    private final Invoice invoice;
    
    InvoiceController(Invoice invoice){
        this.invoice=invoice;
    }

    @GetMapping("/show")
    public Invoice show() {
        return invoice;
    }

}

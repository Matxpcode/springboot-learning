package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private final String name;

    private final String lastname;
    
    public Client(@Value("${client.name}") String name,@Value("${client.lastname}") String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}

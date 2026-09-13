package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@RequestScope
// @JsonIgnoreProperties({ "targetSource", "advisors" })
public class Client {
  private String name;

  private String lastname;

  public Client(@Value("${client.name}") String name, @Value("${client.lastname}") String lastname) {
    this.name = name;
    this.lastname = lastname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}

package com.wrekcode.curso.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Item;
import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration // indica fabrica de beans
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

  // Componente de fabrica - listar items deporte
  @Bean
  List<Item> itemsInvoice() { // deja de ser ambiguo a tener datos fijos
    Product p1 = new Product("Camara Sony", 800);
    Product p2 = new Product("Bicicleta Goliat", 1200);

    Item item1 = new Item(p1, 10);
    Item item2 = new Item(p2, 5);

    return Arrays.asList(item1, item2);
  }

  // puede haber mas de 1 bean de tipo List<Item> ....

  // Componente de fabrica - listar items oficina
  @Bean("default")
  List<Item> itemsInvoiceOffice() {
    Product p1 = new Product("Monitor Asus 24", 700);
    Product p2 = new Product("Notebook Razer", 2400);
    Product p3 = new Product("Impresora HP", 800);
    Product p4 = new Product("Escritorio Oficina", 900);

    Item item1 = new Item(p1, 10);
    Item item2 = new Item(p2, 20);
    Item item3 = new Item(p3, 30);
    Item item4 = new Item(p4, 40);

    return Arrays.asList(item1, item2, item3, item4);
  }
}

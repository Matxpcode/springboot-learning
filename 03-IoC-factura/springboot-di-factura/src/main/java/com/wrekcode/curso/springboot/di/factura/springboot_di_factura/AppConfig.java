package com.wrekcode.curso.springboot.di.factura.springboot_di_factura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Item;
import com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models.Product;

@Configuration 
@PropertySource("classpath:data.properties") 
public class AppConfig {
    
    //Creamos un componente de fabrica
    @Bean("listadoItemsDeporte")
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony",800);
        Product p2 = new Product("Bicicleta Goliat",1200);
        
        Item item1 = new Item(p1, 10);
        Item item2 = new Item(p2, 5);

        return Arrays.asList(item1,item2);
    }
    //puede haber mas de 1 bean de tipo List<Item> ....
}

package com.wreckcode.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wreckcode.springboot.di.app.springboot_di.models.Product;
import com.wreckcode.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service    //componente
public class ProductServiceImpl implements ProductService{
    //Antes manualmente realizamos la instancia
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    //Inyeccion mediante constructor
    private final Environment environment;

    //Inyeccion mediante value
    @Value("${config.price.tax}")
    private Double tax;

    //Ahora spring gestiona la instancia
    private final ProductRepository repository; //llamo a la intefaz repository

    ProductServiceImpl(@Qualifier("productList") ProductRepository repository, Environment environment) {  //inyeccion del component como parametro
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p->{   //300
            System.out.println(environment.getProperty("config.price.tax",Double.class));
            Double priceImp = p.getPrice()*tax;  
            //Usaremos un clone en lugar de un objeto product
            // Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            
            //1. inmutabilidad          
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceImp.longValue());
            return newProduct;

            //2. para probar requestScope / sessionScope
            // p.setPrice(priceImp.longValue());
            // return p;

        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}

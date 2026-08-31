package com.wreckcode.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wreckcode.springboot.di.app.springboot_di.models.Product;
import com.wreckcode.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service    //componente
public class ProductServiceImpl implements ProductService{
    //Antes manualmente realizamos la instancia
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    //Ahora spring gestiona la instancia
    private final ProductRepository repository; //llamo a la intefaz repository

    ProductServiceImpl(ProductRepository repository) {  //inyeccion del component como parametro
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p->{   //300
            Double priceImp = p.getPrice()*1.25d;   //375

            //Usaremos un clone en lugar de un objeto product
            // Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceImp.longValue());

            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}

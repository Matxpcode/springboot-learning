package com.wreckcode.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.wreckcode.springboot.di.app.springboot_di.models.Product;
import com.wreckcode.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {
    private ProductRepository repository = new ProductRepository();

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

    public Product findById(Long id){
        return repository.findById(id);
    }
}

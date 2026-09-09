package com.wrekcode.curso.springboot.di.factura.springboot_di_factura.models;

public class Item {

    private Product product;
    private Integer quantify;
    
    public Item(Product product, Integer quantify) {
        this.product = product;
        this.quantify = quantify;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantify() {
        return quantify;
    }
    public void setQuantify(Integer quantify) {
        this.quantify = quantify;
    }

    public int getImporte(){
        return quantify*product.getPrice();
    }
}

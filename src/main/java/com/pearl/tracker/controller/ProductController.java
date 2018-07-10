package com.pearl.tracker.controller;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ProductController {

    @Inject
    ProductService productService;

  private Product product;

    public String addProduct(){
        System.out.println(product.toString());
        System.out.println("*************************************************");
        productService.addProduct(product);

        return "/index.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void init(){
        product = new Product();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

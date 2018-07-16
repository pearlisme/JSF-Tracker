package com.pearl.tracker.controller;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class ProductController {

    @Inject
    ProductService productService;

    private Product product;
    private List<Product> productList;

    public String addProduct() {


        return productService.addProduct(product);
    }

    @PostConstruct
    public void init() {
        product = new Product();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productService.getProducts();
    }
}

package com.pearl.tracker.service;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "productService")
@SessionScoped
public class ProductServiceImpl implements ProductService ,Serializable {


    @Inject
    ProductRepository productRepository;

    @Override
    public String addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }
}

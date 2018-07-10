package com.pearl.tracker.service;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "productService")
@ApplicationScoped
public class ProductServiceImpl implements ProductService {


    @Inject
    ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}

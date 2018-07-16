package com.pearl.tracker.repository;

import com.pearl.tracker.model.Product;

import java.util.List;

public interface ProductRepository {

    public String addProduct(Product product);
    public List<Product> getProducts();
}

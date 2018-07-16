package com.pearl.tracker.service;


import com.pearl.tracker.model.Product;

import java.util.List;

public interface ProductService {

    public String addProduct(Product product);
    public List<Product> getProducts();
}

package com.pearl.tracker.controller;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    ProductService productService;

    private Product product;
    private List<Product> productList = null;

    public String addProduct() {

        String product1 = productService.addProduct(product);

        FacesMessage facesMessage = new FacesMessage("Product added successfully");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "success";
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
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productService.getProducts();
    }
}

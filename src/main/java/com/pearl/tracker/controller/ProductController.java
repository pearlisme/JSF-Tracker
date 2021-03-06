package com.pearl.tracker.controller;

import com.pearl.tracker.model.Product;
import com.pearl.tracker.service.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    FacesContext facesContext;
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    @Inject
    private Logger logger;


    private Product product = new Product();
    private List<Product> productList =  new ArrayList<Product>();

    public String addProduct() {

        Set<ConstraintViolation<Product>> validationConstraints = validator.validate(product);

        if (validationConstraints.size() > 0) {
            throw new ConstraintViolationException(validationConstraints);
        }

        logger.info(product.toString());
        String product1 = productService.addProduct(product);

        FacesMessage facesMessage = new FacesMessage("Product added successfully");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return "success";
    }

/*    @PostConstruct
    public void init() {
        product = new Product();
        productList = populateProducts();


    }*/

    private List<Product> populateProducts() {

        return productService.getProducts();
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

        this.productList = productList;
    }
}

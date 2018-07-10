/*
package com.pearl.tracker.model;

import com.pearl.tracker.service.ProductService;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PopularProducts {

	@Inject
	private ProductService productService;

	private List<Product> products;

	@PostConstruct
	public void initialize() {
		products = productService.getPopularProducts();
	}

	public List<Product> getProducts() {
		return products;
	}
}
*/

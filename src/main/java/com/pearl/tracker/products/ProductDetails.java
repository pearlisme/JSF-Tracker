package com.pearl.tracker.products;

import java.io.Serializable;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

public class ProductDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ProductService productService;
	
	@Getter
	@Setter 
	private long productId;
	
	@Getter
	@Setter
	private Product product;
	
	
	public void onload() {
		product = productService.getProduct(productId);
	}
	
	public Product getProduct() {
		return product;
	}
	
}

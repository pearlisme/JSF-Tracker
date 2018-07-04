package com.pearl.tracker.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	private final Map<Long, Product> products;

	private final List<Product> popularProducts;

	@Override
	public List<Product> getPopularProducts() {
		return popularProducts;
	}

	@Override
	public Product getProduct(long id) {
		return null;
	}

	public ProductServiceImpl() {
		Map<Long, Product> map = new HashMap<Long, Product>();

		map.put(1L, new Product(1L, "Yonex Racket", "Essential Racket", new BigDecimal(4000.00), ""));
		map.put(2L, new Product(2L, "Yonex Astock Racket", "Essential Racket", new BigDecimal(8000.00), ""));
		map.put(3L, new Product(3L, "Yonex Muscle Power Racket", "Essential Racket", new BigDecimal(5000.00), ""));
		map.put(4L, new Product(4L, "Yonex Ascaber Racket", "Essential Racket", new BigDecimal(4000.00), ""));
		map.put(5L, new Product(5L, "Li ing Racket", "Essential Racket", new BigDecimal(5000.00), ""));

		products = Collections.unmodifiableMap(map);

		popularProducts = Collections.unmodifiableList(new ArrayList<>(products.values()));

	}

}

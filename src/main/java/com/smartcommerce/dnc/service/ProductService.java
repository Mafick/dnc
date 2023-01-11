package com.smartcommerce.dnc.service;

import com.commercetools.api.models.product.Product;

import java.util.List;

public interface ProductService {

	void createProduct(String name, String description, String key);

	List<Product> getAllProducts();
}

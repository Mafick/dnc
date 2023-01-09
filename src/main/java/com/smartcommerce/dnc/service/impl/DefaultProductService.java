package com.smartcommerce.dnc.service.impl;

import org.springframework.stereotype.Service;

import com.smartcommerce.dnc.service.ProductService;


@Service
public class DefaultProductService implements ProductService {

	@Override
	public void createProduct(String name, String description) {

		System.out.println("alluah akbar");
	}
}

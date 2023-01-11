package com.smartcommerce.dnc.service.impl;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import com.smartcommerce.dnc.client.CommercetoolsClient;
import com.smartcommerce.dnc.service.ProductService;


@Service
public class CommercetoolsProductService implements ProductService {
	private final static String LOC_EN = "en-us";
	private final static String LOC_DE = "de-de";

	private final CommercetoolsClient commercetoolsClient;

	public CommercetoolsProductService(CommercetoolsClient commercetoolsClient) {
		this.commercetoolsClient = commercetoolsClient;
	}

	@Override
	public void createProduct(String name, String description, String key) {
		ProjectApiRoot apiRoot = commercetoolsClient.createApiClient();

		// Create Product
		ProductDraft newProductDetails = ProductDraft
				.builder()
				.name(stringBuilder ->
						stringBuilder
								.addValue(LOC_EN, name)
								.addValue(LOC_DE, name)
				)
				.productType(typeBuilder -> typeBuilder.id("5da6ed0e-ef5a-4a1f-86ea-c3ab57556531"))
				.slug(stringBuilder ->
						stringBuilder
								.addValue(LOC_EN, String.format("%s-%s", key, LOC_EN))
								.addValue(LOC_DE, String.format("%s-%s", key, LOC_DE))
				)
				.description(stringBuilder ->
						stringBuilder
								.addValue(LOC_EN, description)
								.addValue(LOC_DE, description)
				)
				.key(key)
				.build();

		// Post the ProductDraft and get the new Product
		Product product = apiRoot
				.products()
				.post(newProductDetails)
				.executeBlocking()
				.getBody();

		// Output the Product ID
		String productID = product.getId();
		System.out.println(productID);
	}

	@Override
	public List<Product> getAllProducts() {
		ProjectApiRoot apiRoot = commercetoolsClient.createApiClient();

		ProductPagedQueryResponse allProducts = apiRoot
				.products()
				.get()
				.executeBlocking()
				.getBody();

		return allProducts.getResults();
	}
}

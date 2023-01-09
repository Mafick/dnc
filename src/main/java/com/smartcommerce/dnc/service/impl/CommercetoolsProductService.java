package com.smartcommerce.dnc.service.impl;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import org.springframework.stereotype.Service;

import com.smartcommerce.dnc.client.CommercetoolsClient;
import com.smartcommerce.dnc.service.ProductService;


@Service
public class CommercetoolsProductService implements ProductService {

	@Override
	public void createProduct(String name, String description) {

		ProjectApiRoot apiRoot = CommercetoolsClient.createApiClient();

		// Create Product
		ProductDraft newProductDetails = ProductDraft
				.builder()
				.name(stringBuilder ->
						stringBuilder
								.addValue("en", "English name for your Product")
								.addValue("de", "German name for your Product")
				)
				.productType(typeBuilder -> typeBuilder.id("Drink"))
				.slug(stringBuilder ->
						stringBuilder
								.addValue("en", "human-readable-url-for-english-product")
								.addValue("de", "human-readable-url-for-german-product")
				)
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
}

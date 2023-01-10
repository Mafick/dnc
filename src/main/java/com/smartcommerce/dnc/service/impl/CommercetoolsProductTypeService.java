package com.smartcommerce.dnc.service.impl;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypePagedQueryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

import com.smartcommerce.dnc.client.CommercetoolsClient;
import com.smartcommerce.dnc.service.ProductTypeService;

@Service
public class CommercetoolsProductTypeService implements ProductTypeService {

	@Override
	public List<ProductType> getAllProductTypes() {
		ProjectApiRoot apiRoot = CommercetoolsClient.createStaticApiClient();

		// Get the new ProductType
		ProductTypePagedQueryResponse allProductTypes = apiRoot
				.productTypes()
				.get()
				.executeBlocking()
				.getBody();

		return allProductTypes.getResults();
	}
}

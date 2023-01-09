package com.smartcommerce.dnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcommerce.dnc.constant.CtrlConst;
import com.smartcommerce.dnc.data.ProductData;
import com.smartcommerce.dnc.service.ProductService;

@Controller
public class ProductPageController {

	private final ProductService productService;

	public ProductPageController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = CtrlConst.PRODUCT_URL, method = RequestMethod.GET)
	public String productPage() {
		return CtrlConst.PRODUCT_PAGE;
	}


	@RequestMapping(value = CtrlConst.PRODUCT_URL, method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("productData") ProductData productData) {
		System.out.println("--- NEW PRODUCT ---");
		System.out.println(productData);

		productService.createProduct(productData.getName(), productData.getDescription());

		return CtrlConst.REDIRECT + CtrlConst.PRODUCT_URL;
	}
}

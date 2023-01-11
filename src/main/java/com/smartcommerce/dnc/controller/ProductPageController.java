package com.smartcommerce.dnc.controller;

import com.commercetools.api.models.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
	public String productPage(Model model) {

		List<Product> allProducts = productService.getAllProducts();
		model.addAttribute("allProducts", allProducts);

		return CtrlConst.PRODUCT_PAGE;
	}


	@RequestMapping(value = CtrlConst.PRODUCT_URL, method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("productData") ProductData productData) {
		System.out.println("--- NEW PRODUCT ---");
		System.out.println(productData);

		productService.createProduct(productData.getName(), productData.getDescription(), productData.getKey());

		return CtrlConst.REDIRECT + CtrlConst.PRODUCT_URL;
	}
}

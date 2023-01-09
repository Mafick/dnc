package com.smartcommerce.dnc.controller;

import com.commercetools.api.models.product_type.ProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import com.smartcommerce.dnc.constant.CtrlConst;
import com.smartcommerce.dnc.service.ProductTypeService;

@Controller
public class ProductTypeController {

	private final ProductTypeService productTypeService;

	public ProductTypeController(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	@RequestMapping(value = CtrlConst.PRODUCT_TYPE_URL, method = RequestMethod.GET)
	public String productTypePage(Model model) {
		List<ProductType> allProductTypes = productTypeService.getAllProductTypes();
		model.addAttribute("allProductTypes", allProductTypes);

		return CtrlConst.PRODUCT_TYPE_PAGE;
	}
}

package com.smartcommerce.dnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcommerce.dnc.constant.CtrlConst;

@Controller
public class ProductPageController {

	@RequestMapping(value = CtrlConst.PRODUCT_URL, method = RequestMethod.GET)
	public String productPage() {
		return CtrlConst.PRODUCT_PAGE;
	}
}

package com.smartcommerce.dnc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartcommerce.dnc.constant.CtrlConst;

@Controller
public class HomePageController extends AbstractPageController {

	@RequestMapping(value = CtrlConst.HOME_URL, method = RequestMethod.GET)
	public String homePage() {
		return CtrlConst.HOME_PAGE;
	}
}

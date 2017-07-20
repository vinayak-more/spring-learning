package com.spittr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = { "/", "/homepage" })
public class HomeController {

	@RequestMapping(method = GET)
	public String home() {
		System.out.println("HomeController.home()");
		return "home";
	}

}

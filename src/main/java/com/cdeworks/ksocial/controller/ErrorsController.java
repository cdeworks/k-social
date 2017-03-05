package com.cdeworks.ksocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors")
public class ErrorsController {
	
	@RequestMapping("/403")
	public String error403() {
		return "/errors/403";
	}
	
	@RequestMapping("/404")
	public String error404() {
		return "/errors/404";
	}

}

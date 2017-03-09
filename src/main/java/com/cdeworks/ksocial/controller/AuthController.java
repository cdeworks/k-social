package com.cdeworks.ksocial.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String loginPage(Principal user) {
		if(user != null) {
			return "redirect:/home";
		}
		return "login";
	}

}

package com.cdeworks.ksocial.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@RequestMapping("/login")
	public String loginPage(@AuthenticationPrincipal User user) {
		if(user != null) {
			return "redirect:/home";
		}
		return "login";
	}

}

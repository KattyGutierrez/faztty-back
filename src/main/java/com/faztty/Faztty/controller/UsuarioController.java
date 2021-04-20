package com.faztty.Faztty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	
	@GetMapping({"/login"})
	public String login() {
		return "v_login";
	}
	
	@PostMapping({"/login"})
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

		if(username.equals("comprador")) {
			return "redirect:/principal/1";
		}else if (username.equals("vendedor")) {
			return "redirect:/mitienda";
		}else {
			return "redirect:/login";
		}
	}

}

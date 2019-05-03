package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administrador")
public class AdminController {

	@PostMapping("/login")
	public ModelAndView login(String nome,String senha) {
		if(nome.equals("admin") && senha.equals("123")) {
			return home();
		}
		return new IndexController().index();
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("administrador/home");
	}
}
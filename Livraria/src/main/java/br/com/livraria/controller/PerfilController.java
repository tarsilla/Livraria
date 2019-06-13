package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	@GetMapping("/perfil")
	public ModelAndView perfil() {
		return new ModelAndView("perfil/perfil");
	}
}

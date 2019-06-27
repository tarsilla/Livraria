package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Usuario;
import br.com.livraria.service.SessionService;
import br.com.livraria.service.UsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private SessionService<Usuario> serviceSession;

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");	
	}
	
	@GetMapping("/entrar")
	public String entrar() {
		return "login";
	}
}

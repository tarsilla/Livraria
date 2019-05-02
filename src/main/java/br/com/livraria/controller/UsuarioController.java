package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Usuario;
import br.com.livraria.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@PostMapping("/saveUsuario")
	public ModelAndView saveUsuario(Usuario usuario) {
		service.save(usuario);
		return findAll();
	}
	
	@RequestMapping("/cadastro-usuario")
	public ModelAndView addUsuario(Usuario usuario) {
		ModelAndView view = new ModelAndView("usuario/cadastro-usuario");
		view.addObject("usuario",usuario);
		return view;
	}
	
	@GetMapping("/lista-usuarios")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("usuario/lista-usuarios");
		view.addObject("usuarios", service.findAll());
		return view;
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView updateUsuario(@PathVariable("id") Long id) {
		Usuario usuario = service.findOne(id);
		return addUsuario(usuario);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteUsuario(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
}

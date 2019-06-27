package br.com.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Usuario;
import br.com.livraria.service.RoleService;
import br.com.livraria.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private RoleService serviceRole;
	
	@GetMapping("/cadastro-usuario") 
	public ModelAndView cadastrar(Usuario usuario) {
		
		ModelAndView view = new ModelAndView("usuario/cadastro");
		view.addObject("usuario", usuario); 
		view.addObject("roles", serviceRole.buscarTodos());
		return view;
	} 
	
	@PostMapping("/saveUsuario")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result) {
		
		if (result.hasErrors()) {
			return cadastrar(usuario);
		}

		service.add(usuario);
		ModelAndView rec = findAll();
		return rec;
	}
	
	@GetMapping("/lista-usuario")
	public ModelAndView findAll() {		
		ModelAndView view = new ModelAndView("usuario/lista-usuarios"); 
		view.addObject("usuarios", service.findAll());	
		return view;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {		
		return cadastrar(service.getOne(id));
	}
	
	@GetMapping("/pesquisar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("usuarios", service.buscarPorNome(nome));
		return "/usuario/lista-usuarios";
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		service.delete(id);		
		return findAll();
	}
	
	
}

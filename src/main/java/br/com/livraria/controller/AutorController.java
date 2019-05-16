package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Autor;
import br.com.livraria.service.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService service;
	
	@PostMapping("/saveAutor")
	public ModelAndView saveAutor(Autor autor) {
		service.save(autor);
		return findAll();
	}
	
	@RequestMapping("/cadastro-autor")
	public ModelAndView addAutor(Autor autor) {
		ModelAndView view = new ModelAndView("autor/cadastro-autor");
		view.addObject("autor",autor);
		return view;
	}
	
	@GetMapping("/lista-autor")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("autor/lista-autor");
		view.addObject("autores", service.findAll());
		return view;
	}
}

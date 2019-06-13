package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;
	
	@PostMapping("/saveLivro")
	public ModelAndView saveLivro(Livro livro) {
		service.save(livro);
		return findAll();
	}
	
	@RequestMapping("/cadastro-livro")
	public ModelAndView addLivro(Livro livro) {
		ModelAndView view = new ModelAndView("livro/cadastro-livro");
		view.addObject("livro",livro);
		return view;
	}
	
	@GetMapping("/lista-livro")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("livro/lista-livro");
		view.addObject("livros", service.findAll());
		return view;
	}
}

package br.com.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView saveAutor(@Valid Autor autor,BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(autor);
		}
		service.save(autor);
		ModelAndView rec = findAll();
		return rec;
	}
	
	@RequestMapping("/cadastro-autor")
	public ModelAndView cadastrar(Autor autor) {
		ModelAndView view = new ModelAndView("autor/cadastro-autor");
		view.addObject("autor",autor);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Autor autor = service.findOne(id);
		return cadastrar(autor);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@GetMapping("/lista-autor")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("autor/lista-autor");
		view.addObject("autores", service.findAll());
		return view;
	}
}

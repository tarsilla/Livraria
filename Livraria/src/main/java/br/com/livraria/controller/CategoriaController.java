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

import br.com.livraria.model.Categoria;
import br.com.livraria.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@PostMapping("/saveCategoria")
	public ModelAndView saveCategoria(@Valid Categoria categoria,BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(categoria);
		}
		service.save(categoria);
		ModelAndView rec = findAll();
		return rec;
	}
	
	@RequestMapping("/cadastro-categoria")
	public ModelAndView cadastrar(Categoria categoria) {
		ModelAndView view = new ModelAndView("categoria/cadastro-categoria");
		view.addObject("categoria",categoria);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Categoria categoria = service.findOne(id);
		return cadastrar(categoria);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@GetMapping("/lista-categoria")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("categoria/lista-categoria");
		view.addObject("categorias", service.findAll());
		return view;
	}
}

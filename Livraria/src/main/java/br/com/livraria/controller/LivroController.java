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

import br.com.livraria.model.Livro;
import br.com.livraria.service.AutorService;
import br.com.livraria.service.CategoriaService;
import br.com.livraria.service.EditoraService;
import br.com.livraria.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;
	
	@Autowired
	private AutorService autorService;

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EditoraService editoraService;
	
	@PostMapping("/saveLivro")
	public ModelAndView saveLivro(@Valid Livro livro, BindingResult result	) {
		if(result.hasErrors()) {
			return cadastrar(livro);
		}
		service.save(livro);
		return findAll();
	}
	
	@RequestMapping("/cadastro-livro")
	public ModelAndView cadastrar(Livro livro) {
		ModelAndView view = new ModelAndView("livro/cadastro-livro");
		view.addObject("autores",autorService.findAll());
		view.addObject("editoras",editoraService.findAll());
		view.addObject("categorias",categoriaService.findAll());
		view.addObject("livro",livro);
		return view;
	}
	
	@GetMapping("/lista-livro")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("livro/lista-livro");
		view.addObject("livros", service.findAll());
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Livro livro = service.findOne(id);
		return cadastrar(livro);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
}

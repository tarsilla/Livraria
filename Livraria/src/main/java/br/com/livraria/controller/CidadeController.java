package br.com.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.enums.UnidadeF;
import br.com.livraria.model.Cidade;
import br.com.livraria.service.CidadeService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@PostMapping("/saveCidade")
	public ModelAndView saveCategoria(@Valid Cidade cidade ,BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(cidade);
		}
		service.save(cidade);
		ModelAndView rec = findAll();
		return rec;
	}
	
	@RequestMapping("/cadastro-cidade")
	public ModelAndView cadastrar(Cidade cidade) {
		ModelAndView view = new ModelAndView("cidade/cadastro-cidade");
		view.addObject("cidade",cidade);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Cidade cidade= service.findOne(id);
		return cadastrar(cidade);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@GetMapping("/lista-cidade")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("cidade/lista-cidade");
		view.addObject("cidades", service.findAll());
		return view;
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> listaDeCidades() {
		return service.findAll();			
	}	
	
	@ModelAttribute("ufs")
	public UnidadeF[] getUnidadeF() {
		return UnidadeF.values();
	}
}

package br.com.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Editora;
import br.com.livraria.service.EditoraService;

@Controller
@RequestMapping("/editora")
public class EditoraController {

	@Autowired
	private EditoraService service;
	
	@PostMapping("/saveEditora")
	public ModelAndView saveEditora(@Valid Editora editora,BindingResult result) {
		if(result.hasErrors()) {
			return addEditora(editora);
		}
		service.save(editora);
		ModelAndView rec = findAll();
		return rec;
	}
	
	@RequestMapping("/cadastro-editora")
	public ModelAndView addEditora(Editora editora) {
		ModelAndView view = new ModelAndView("editora/cadastro-editora");
		view.addObject("editora",editora);
		return view;
	}
	
	@GetMapping("/lista-editora")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("editora/lista-editora");
		view.addObject("editoras", service.findAll());
		return view;
	}
}

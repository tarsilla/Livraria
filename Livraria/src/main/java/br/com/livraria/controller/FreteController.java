package br.com.livraria.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.livraria.model.Frete;
import br.com.livraria.service.FreteService;

@Controller
@RequestMapping("/frete")
public class FreteController {

	@Autowired
	private FreteService service;
	
	@PostMapping("/saveFrete")
	public ModelAndView saveFrete(@Valid Frete frete, BindingResult result) throws JsonProcessingException  {
		if(result.hasErrors()) {
			return cadastrar(frete);
		}
		
		frete.setDataEntregaCorreios(new Date());
		service.save(frete);		
		return details(frete.getId());
	}
	
	@GetMapping("/cadastro-frete")
	public ModelAndView cadastrar(Frete frete) {
		Double valor = 2.0;
		frete.setValor(valor);
		ModelAndView view = new ModelAndView("frete/cadastro-frete");
		view.addObject("frete",frete);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Frete frete = service.findOne(id);
		return cadastrar(frete);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView("frete/lista-frete");
		view.addObject("frete", service.findOne(id));
		
		return view;
	}
	
	@GetMapping("/alldetails/{id}")
	public ModelAndView alldetails(@PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView("frete/detalhes");
		view.addObject("frete", service.findOne(id));
		
		return view;
	}
	
	@GetMapping("/detailsByPedido/{id}")
	public ModelAndView detailsByPedido(@PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView("frete/detailsByPedido");
		view.addObject("frete", service.findOne(id));
		
		return view;
	}
	
	@GetMapping("/lista-frete")
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("frete/lista-frete");
		view.addObject("fretes", service.findAll());
		return view;
	}
}

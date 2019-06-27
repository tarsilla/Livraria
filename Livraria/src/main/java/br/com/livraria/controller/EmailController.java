package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Email;
import br.com.livraria.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService service;
	
	@PostMapping("/sendEmail")
	public ModelAndView enviarEmail(Email email) {
	//	emailServicee.sendEmailText(email, email.getTexto());
		return success();
	}
	
	public ModelAndView success() {
		ModelAndView view = new ModelAndView("/usuario/portal-user");
		view.addObject("success", "Email Enviado com Sucesso!");
		return view;
	}
}

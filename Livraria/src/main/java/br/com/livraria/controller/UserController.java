package br.com.livraria.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Email;
import br.com.livraria.model.Role;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.EmailService;
import br.com.livraria.service.RoleService;
import br.com.livraria.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmailService sendEmail;
	
	@Autowired
	private UsuarioService service;
	 
	@Autowired
	private RoleService serviceRole;
	
	@GetMapping("/cadastrar") 
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("user/cadastro");
		mv.addObject("usuario", usuario);
		return mv;
	} 
	
	@PostMapping("/saveUser")
	public ModelAndView save(Usuario usuario) {		
		Role role = serviceRole.getNome("CLIENTE");
		if(role == null) {
			role = new Role();
			role.setNome("CLIENTE");
			serviceRole.add(role);
		}
		
		Usuario usuario2 = service.getEmail(usuario.getEmail());
		ModelAndView view = new ModelAndView("login");
		
		if(usuario2 != null) {		
			view.addObject("error", "Email já está cadastrado no sistema!");
		}else {
			usuario.getRole().add(role);
			service.add(usuario);
			Email email = new Email();
			email.setTo(usuario.getEmail());
			sendEmail.sendEmailBemVindo(email);
			view.addObject("mensagem", "Usuário cadastrado com sucesso!");
		}
		return view;		
	}
	 
	@GetMapping("/atualizar") 
	public ModelAndView atualizar() {
		ModelAndView mv = new ModelAndView("user/trocar_senha");
		return mv;
	}  
	
	@PostMapping("/update")
	public ModelAndView update(@RequestParam("email") String email) {
		
		Usuario usuario2 = service.getEmail(email);
		ModelAndView view = new ModelAndView("login");
		
		if(usuario2 == null) {		
			view.addObject("error", "Email não está cadastrado no sistema!");
		}else {
			Random r = new Random();
			String novaSenhaGerada = Integer.toString(Math.abs(r.nextInt()), 36).substring(0, 6);
			System.out.println(novaSenhaGerada);
			usuario2.setSenha(novaSenhaGerada);
			service.add(usuario2);
			Email email2 = new Email();
			email2.setTo(usuario2.getEmail());
			sendEmail.sendNovaSenhaEmail(email2, novaSenhaGerada);
			view.addObject("mensagem", "Sua nova senha");
		}
		return view;		
	}
}

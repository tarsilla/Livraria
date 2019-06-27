package br.com.livraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Email;
import br.com.livraria.model.Usuario;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	public void sendEmailBemVindo(Email email) {
		try {
			Usuario usuario = serviceUsuario.getEmail(email.getTo());
			email.setFrom("livrariaceuazul@gmail.com");
			email.getMap().put("name", usuario.getNome());
			email.setSubject("Bem-vindo ao site Livraria Céu Azul! :)");
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText("Seja bem vindo ao site da Livraria Céu Azul :)");
			message.setFrom(email.getFrom());
			
			emailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendNovaSenhaEmail(Email email, String novaSenha) {
		try {
			Usuario usuario = serviceUsuario.getEmail(email.getTo());
			email.setFrom("livrariaceuazul@gmail.com");
			email.getMap().put("name", usuario.getNome());
			email.setSubject("Confira sua nova senha da Livraria Céu Azul! :)");
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getTo());
			message.setSubject(email.getSubject());
			message.setText("Nova senha: " + novaSenha);
			message.setFrom(email.getFrom());
			
			emailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMail(String texto, String email){
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		System.out.println(email + " *****************************************");
		
        message.setText(texto);
        message.setSubject("Sua compra foi realizada com Sucesso! Livraria Céu Azul :)");
        message.setTo(email);
        message.setFrom("livrariaceuazul@gmail.com");
        
        try {
        	emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}

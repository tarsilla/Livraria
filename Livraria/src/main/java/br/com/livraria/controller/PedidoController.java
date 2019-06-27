package br.com.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.livraria.model.Usuario;
import br.com.livraria.service.EmailService;
import br.com.livraria.service.FreteService;
import br.com.livraria.service.ItemPedidoService;
import br.com.livraria.service.LivroService;
import br.com.livraria.service.PedidoService;
import br.com.livraria.service.SessionService;
import br.com.livraria.service.UsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private FreteService freteService;

	@Autowired
	private ItemPedidoService  itemPedidoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SessionService<Usuario> serviceSession;
	
	
}

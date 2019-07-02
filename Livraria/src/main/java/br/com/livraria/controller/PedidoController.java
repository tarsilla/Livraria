package br.com.livraria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.enums.StatusPedido;
import br.com.livraria.model.Frete;
import br.com.livraria.model.ItemPedido;
import br.com.livraria.model.Livro;
import br.com.livraria.model.Pedido;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.EmailService;
import br.com.livraria.service.FreteService;
import br.com.livraria.service.ItemPedidoService;
import br.com.livraria.service.LivroService;
import br.com.livraria.service.PedidoService;
import br.com.livraria.service.SessionService;

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
	private LivroService livroService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SessionService<Usuario> serviceSession;
	
	
	@RequestMapping("/cadastro-pedido")
	public ModelAndView cadastrar(Pedido pedido) {
		ModelAndView mv = new ModelAndView("pedido/cadastro-pedido");
		mv.addObject("logado", serviceSession.getSession("usuario"));
		mv.addObject("pedido", pedido);
		return mv;
	}
	
	@GetMapping("/addPedido/{id}")
	public ModelAndView addPedido(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		
		Usuario usuario = serviceSession.getSession("usuario");
		
		System.out.println(" Chama função sendMail *********************** " + usuario.getEmail());
		emailService.sendMail("Livraria - Compra Realizada", usuario.getEmail());
		System.out.println(" depois da função sendMail *****************************************");
		
		Pedido pedido = new Pedido();
		pedido.setNomeusuario(usuario.getNome());
		pedido.setEmailusuario(usuario.getEmail());
		
		pedidoService.cadastrar(pedido);
		
		ItemPedido itempedido = itemPedidoService.findOne(id);
		
		itempedido.setPedido(pedido);
		
		itemPedidoService.save(itempedido);
		Frete frete = itempedido.getFrete();
		
		pedido.setValorTotal(itempedido.getValorTotal());
		pedido.setData(new Date());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		pedido.setCompra(format.format(pedido.getData()));
		pedido.setStatusPedido(StatusPedido.ANDAMENTO);
		
		
		pedido.setUsuario(usuario);
		
		pedidoService.cadastrar(pedido);
		
		frete.setPedido(pedido);
		freteService.save(frete);
		
		ModelAndView mv = new ModelAndView("frete/cadastro-pedido");
		mv.addObject("pedido", pedido);
		mv.addObject("frete", frete);
		
		return mv;
	}
	
	@GetMapping("/lista-pedido")
	private ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("pedido/lista-pedido");
        mv.addObject("pedidos", pedidoService.findAll());
        return mv;
	}
	
	
	@PostMapping("/savePedido")
    public ModelAndView savePedido(@Valid Pedido pedido, BindingResult result) {
		 
		if(result.hasErrors()) {
			return cadastrar(pedido);
	    }

		pedidoService.cadastrar(pedido);
		ModelAndView rec = findAll(); 
		return rec;
    }
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findOne(id);
		return cadastrar(pedido);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		pedidoService.delete(id);
		return findAll();
	}
	
	@ModelAttribute("livros")
	public List<Livro> listaDeLivros() {
		return livroService.findAll();
	}	
	
	@GetMapping("/buscar/compra")
	public ModelAndView getPorData(@RequestParam("compra") String compra, ModelMap model) {
		model.addAttribute("pedido", pedidoService.buscarPorData(compra));
		ModelAndView mv = new ModelAndView("/pedido/lista");
		mv.addObject("pedido", pedidoService.buscarPorData(compra));
		mv.addObject("valorTot", pedidoService.totalData(compra));
		return mv;
	}
	
	@GetMapping("/buscar2/emailusuario")
	public ModelAndView getPorNome(@RequestParam("emailusuario") String emailusuario, ModelMap model) {
		model.addAttribute("pedido", pedidoService.buscarPorEmail(emailusuario));
		ModelAndView mv = new ModelAndView("/pedido/lista");
		mv.addObject("pedido", pedidoService.buscarPorEmail(emailusuario));
		return mv;
	}
	
	@GetMapping("/listar2")
	public ModelAndView getPorNome(ModelMap model) {
		Usuario usuario = serviceSession.getSession("usuario");
		
		String emailusuario = usuario.getEmail();
		
		model.addAttribute("pedido", pedidoService.buscarPorEmail(emailusuario));
		ModelAndView mv = new ModelAndView("/pedido/lista");
		mv.addObject("pedido", pedidoService.buscarPorEmail(emailusuario));
		return mv;
	}
}

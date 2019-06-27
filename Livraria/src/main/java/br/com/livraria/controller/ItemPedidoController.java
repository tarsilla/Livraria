package br.com.livraria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.livraria.model.Endereco;
import br.com.livraria.model.Frete;
import br.com.livraria.model.ItemPedido;
import br.com.livraria.model.Livro;
import br.com.livraria.model.Usuario;
import br.com.livraria.service.FreteService;
import br.com.livraria.service.ItemPedidoService;
import br.com.livraria.service.LivroService;
import br.com.livraria.service.SessionService;
import br.com.livraria.service.UsuarioService;

@Controller
@RequestMapping("/itemPedido")
public class ItemPedidoController {

	@Autowired
	private SessionService<Usuario> serviceSession;
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private ItemPedidoService service;
	
	@Autowired
	private LivroService serviceLivro;
	
	@Autowired
	private FreteService servicefrete;
	

	@PostMapping("/saveItemPedido")
	public ModelAndView saveAutor(@Valid ItemPedido itemPedido ,BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(itemPedido);
		}
		service.save(itemPedido);
		
		Frete frete = new Frete();
		String cep = itemPedido.getCep();
		
		double valor = 0.0;
		int i = 0;
		double pesoLivros = 0.0;
		
		List<Livro> livros = itemPedido.getLivro();
		
		for(Livro l : livros) {
			valor += Double.parseDouble(l.getPreco());
			pesoLivros += l.getPeso();
			i++;
		}
		
		RestTemplate template = new RestTemplate();
		Endereco endereco = template.getForObject("https://viacep.com.br/ws/" + cep + "/json", Endereco.class);
		
		if(endereco != null) {
			frete.setUnidadeF(endereco.getUnidadeF());
			frete.setCidade(endereco.getCidade());
			frete.setBairro(endereco.getBairro());
			frete.setCepOrigem(cep);
			frete.setRua(endereco.getRua());		
		}
		
		String prec = itemPedido.getPreco();
		String dias = itemPedido.getPrazo();
		
		prec = prec.replaceAll(",", ".");
		
		double preco = Double.parseDouble(prec);
		int prazoDias = Integer.parseInt(dias);
			frete.setCepOrigem("59810000");
			frete.setPeso(pesoLivros);
			frete.setValor(preco);
			frete.setTempoDias(prazoDias);
			
		Date a = new Date();
		a.setDate(a.getDate() + prazoDias);
		
		String formatoData = "dd/MM/yyyy";
		SimpleDateFormat dataFormatada = new SimpleDateFormat(formatoData);
		
		frete.setDataEntregaCliente(dataFormatada.format(a));
		
		servicefrete.save(frete);
		itemPedido.setFrete(frete);
		
		valor += preco;
		itemPedido.setValorTotal(valor);
		itemPedido.setQuantidade(i);
		
		service.save(itemPedido);
		
		return detalhes(itemPedido.getId());
	}
	
	@GetMapping("/detalhes/{id}")
	public ModelAndView detalhes(@PathVariable("id") Long id) {	
		ModelAndView mv = new ModelAndView("itemPedido/detalhes");
		mv.addObject("itemPedidos", service.findOne(id));
		
		return mv; 
	}
	
	@RequestMapping("/cadastro-itemPedido")
	public ModelAndView cadastrar(ItemPedido itemPedido) {
		ModelAndView view = new ModelAndView("itemPedido/cadastro-itemPedido");
		view.addObject("livros",serviceLivro.findAll());
		view.addObject("itemPedidos",itemPedido);
		return view;
	}
	
	@GetMapping("/editar/{id}")
	private ModelAndView editar( @PathVariable("id") Long id) {
		ItemPedido itemPedido = service.findOne(id);
		return cadastrar(itemPedido);
	}
	
	@GetMapping("/remover/{id}")
	private ModelAndView remover( @PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@GetMapping("/lista-itemPedido")
	public ModelAndView findAll() {
		Usuario usuarioByEmail = serviceUsuario.getEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		serviceSession.criarSession("usurio", usuarioByEmail);
		
		ModelAndView view = new ModelAndView("itemPedido/lista-itemPedido");
		view.addObject("itemPedidos", service.findAll());
		return view;
	}
	
}

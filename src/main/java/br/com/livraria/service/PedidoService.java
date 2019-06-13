package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Pedido;
import br.com.livraria.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public void save(Pedido pedido) {
		repository.saveAndFlush(pedido);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Pedido findOne(Long id) {
		return repository.getOne(id);
	}
}

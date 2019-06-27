package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.livraria.model.Frete;
import br.com.livraria.model.Pedido;
import br.com.livraria.repository.FreteRepository;

@Service
public class FreteService {

	@Autowired
	private FreteRepository repository;
	
	public List<Frete> findAll(){
		return repository.findAll();
	}
	
	public Frete save(Frete frete) {
		return repository.saveAndFlush(frete);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Frete findOne(Long id) {
		return repository.getOne(id);
	}
	

	public Frete findByPedido(Pedido pedido) {
		return repository.findByPedido(pedido);
	}
}

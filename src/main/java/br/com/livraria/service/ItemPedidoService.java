package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.ItemPedido;
import br.com.livraria.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository repository;
	
	public List<ItemPedido> findAll(){
		return repository.findAll();
	}
	
	public void save(ItemPedido itemPedido) {
		repository.saveAndFlush(itemPedido);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public ItemPedido findOne(Long id) {
		return repository.getOne(id);
	}
}

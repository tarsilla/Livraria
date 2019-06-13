package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Estado;
import br.com.livraria.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll(){
		return repository.findAll();
	}
	
	public void save(Estado estado) {
		repository.saveAndFlush(estado);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Estado findOne(Long id) {
		return repository.getOne(id);
	}
}

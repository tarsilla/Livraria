package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Endereco;
import br.com.livraria.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public void save(Endereco endereco) {
		repository.saveAndFlush(endereco);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Endereco findOne(Long id) {
		return repository.getOne(id);
	}
}

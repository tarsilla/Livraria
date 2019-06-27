package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	
	public Livro save(Livro livro) {
		return repository.saveAndFlush(livro);
	}
	
	public List<Livro> findByPedido(Long id) {
		return repository.findByPedido(id);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Livro findOne(Long id) {
		return repository.getOne(id);
	}
}

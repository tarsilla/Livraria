package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Autor;
import br.com.livraria.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	public List<Autor> findAll(){
		return repository.findAll();
	}
	
	public void save(Autor autor) {
		repository.saveAndFlush(autor);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Autor findOne(Long id) {
		return repository.getOne(id);
	}
}

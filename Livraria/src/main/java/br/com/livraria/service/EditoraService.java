package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Editora;
import br.com.livraria.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	public List<Editora> findAll(){
		return repository.findAll();
	}
	
	public Editora save(Editora editora) {
        return repository.saveAndFlush(editora);
    }
	
	public void cadastrar(Editora editora) {
		repository.saveAndFlush(editora);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Editora findOne(Long id) {
		return repository.getOne(id);
	}
}

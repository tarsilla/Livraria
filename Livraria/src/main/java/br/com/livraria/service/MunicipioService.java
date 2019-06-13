package br.com.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livraria.model.Municipio;
import br.com.livraria.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repository;
	
	public List<Municipio> findAll(){
		return repository.findAll();
	}
	
	public void save(Municipio municipio) {
		repository.saveAndFlush(municipio);
	}
	
	public void update (Long id) {
		// TODO Auto-generated method stub
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public Municipio findOne(Long id) {
		return repository.getOne(id);
	}
}

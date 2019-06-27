package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.livraria.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	public List<Cidade> findByNomeLike(String nome);
	
	@Query("select cidade from Categoria cidade where cidade.nome = ? 1")
	public List<Cidade> findByName(String nome);
}

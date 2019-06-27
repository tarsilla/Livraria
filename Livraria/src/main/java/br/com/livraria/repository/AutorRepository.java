package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	public List<Autor> findByNomeLike(String nome);
	
	@Query("select autor from Autor autor where autor.nome = ? 1")
	public List<Autor> findByName(String nome);
}

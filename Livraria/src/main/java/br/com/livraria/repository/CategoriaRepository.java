package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findByNomeLike(String nome);
	
	@Query("select categoria from Categoria categoria where categoria.nome = ? 1")
	public List<Categoria> findByName(String nome);
}

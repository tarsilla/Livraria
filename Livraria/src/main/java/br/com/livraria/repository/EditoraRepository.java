package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

	public List<Editora> findByNomeLike(String nome);
	
	@Query("select editora from Editora editora where editora.nome = ? 1")
	public List<Editora> findByName(String nome);
}

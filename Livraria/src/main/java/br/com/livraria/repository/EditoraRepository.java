package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{

}

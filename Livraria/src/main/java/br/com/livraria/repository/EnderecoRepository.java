package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

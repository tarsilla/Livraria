package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{

}

package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

}

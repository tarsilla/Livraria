package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long>{

}

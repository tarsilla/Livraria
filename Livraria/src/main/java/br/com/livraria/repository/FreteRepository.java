package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Frete;
import br.com.livraria.model.Pedido;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long>{

	@Query("select frete from Frete frete where frete.pedido = ? 1")
	public Frete findByPedido(Pedido pedido);
}

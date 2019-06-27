package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.ItemPedido;
import br.com.livraria.model.Pedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

	@Query("select itemPedido from ItemPedido itemPedido where itemPedido.pedido = ? 1")
	public List<ItemPedido> findByListPedido(List<Pedido> pedidos);
}

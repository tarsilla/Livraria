package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Pedido;
import br.com.livraria.model.Usuario;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("select pedido from Pedido pedido where pedido.usuario = ? 1")
	public List<Pedido> findByUsuario(Usuario usuario);
}

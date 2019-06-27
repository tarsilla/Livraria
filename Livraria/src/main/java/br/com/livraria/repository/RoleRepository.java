package br.com.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("select role from Role role where role.nome = ? 1")
	public Role findByNome(String nome);
}

package br.com.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.livraria.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

public List<Usuario> findByNomeLike(String nome);
	
	@Query
	public Usuario findByEmail(String email);
	@Query
	public Usuario findByEmailAndSenha(String email, String senha);
	@Query
	public Usuario findByNome(String nome);
	@Query
	Usuario findByUsername(String username);
	
	@Query("select usuario from Usuario usuario where usuario.nome = ? 1")
	public List<Usuario> findByName(String nome);
}

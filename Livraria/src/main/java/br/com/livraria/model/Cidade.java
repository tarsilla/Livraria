package br.com.livraria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.livraria.enums.UnidadeF;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=70, name="nome")
	@NotBlank(message="Nome é uma informação obrigatoria!")
	private String nome;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UnidadeF unidadeFederal;
	
	@OneToMany(mappedBy = "cidades")
	private List<Usuario> usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeF getUnidadeFederal() {
		return unidadeFederal;
	}

	public void setUnidadeFederal(UnidadeF unidadeFederal) {
		this.unidadeFederal = unidadeFederal;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
